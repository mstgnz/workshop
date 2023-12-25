class Wizard{

    constructor(){
        // Satır Ve Sütün Modal Submit
        document.querySelector('.rowModalSubmit').addEventListener('click',this.rowModalSubmit);
        document.querySelector('.columnModalSubmit').addEventListener('click',this.columnModalSubmit);
        // Satır Ekle Buton Animasyon
        document.addEventListener('mousemove', m => {
            document.querySelector('#add-row').style.top = (m.pageY-20)+'px';
        });
        // Verileri Çek
        this.getStorage()
        // sayfayı güncelle
        this.updatePage()
        // modülleri yükle
        this.addHtml()
    }

    // Satır Ekle
    rowModalSubmit = () => {
        // Elementleri Seç
        this.getInput = document.getElementById('columnType');
        this.rowName = document.querySelector('input[name=rowname]')
        this.fluid = document.querySelector('select[name=screen-type]')
        this.wizard = document.getElementById('wizard')
        let date = new Date().getTime();
        this.getInput = this.getInput.value.split(',');
        // Satır oluştur
        let row = {
            id: date,
            type: "row",
            name: this.rowName.value,
            fluid: this.fluid.value,
            css:{},
        }
        let count = 1;
        let sum = 0;
        let columns = [];
        this.getInput.forEach(el => {
            sum += parseInt(el);
            // Sütunları oluştur
            columns.push({
                id: date+count,
                type: "column",
                col: el,
                css: {},
                module: {
                    id: 1,
                    name: "",
                    css:{}
                }
            })
            count++;
        });
        if(sum>12 || 12 % sum !== 0 || sum<0){
            alert('Sütun tipi seçmediniz')
        }else{
            // Satıra sütünü ekle
            row['columns'] = columns;
            // Storage Ekle
            this.wJson.push(row)
            this.addStorage()
            // Sayfaya Ekle
            this.addPage(row);
        }
        // form temizle
        this.formClear()
    }

    // Sütun Ayarları
    columnModalSubmit = () => {
        let rowID = document.querySelector('#columnModal').querySelector('input[name=id]').value
        let moduleName = document.querySelector('#columnModal').querySelector('select[name=module]').value
        this.addModule(rowID, moduleName)
    }

    // Storage select
    getStorage = () => {
        if (localStorage.getItem("Wizard") === null) {
            this.wJson = []
        }else{
            this.wJson = JSON.parse(localStorage.getItem("Wizard"));
        }
    }

    // Storage insert
    addStorage = () => {
        localStorage.setItem("Wizard",JSON.stringify(this.wJson));
    }

    // Dom insert
    addPage = (row) => {
        let container = row.fluid==1 ? 'container-fluid' : 'container';
        let columns = `<div class="${container}"><div class="row">`;
        row.columns.forEach(c => {
            columns += `<div id="${c.id}" class="col-md-${c.col} start">
                <i class="fas fa-cog" onclick="wizard.setModalID(${c.id})" data-toggle="modal" data-target="#columnModal"></i>
            </div>`;
        });
        columns += '</div></div>';
        this.wizard.innerHTML += columns;
    }

    // Sütuna Modül Ekle
    async addModule(rowID,module){
        let html = `<i class="fas fa-cog" onclick="wizard.setModalID(${rowID})" data-toggle="modal" data-target="#columnModal"></i>`;
        let response = await fetch('modules/'+module+'.html');
        html += await response.text();
        document.getElementById(rowID).innerHTML = html;
        this.updateJson(rowID,module)
        this.addStorage() 
    }

    // Satır formunu temizle
    formClear(){
        document.querySelector('input[name=rowname]').value = "";
        document.querySelectorAll('#column-list li').forEach(li =>{ li.style.background = "" });
    }

    // Eklenen modülü json objesine de ekle
    updateJson(rowID,module){
        rowID = parseInt(rowID);
        this.wJson = JSON.parse(localStorage.getItem("Wizard"));
        let path = ""
        for (let i=0; i<this.wJson.length; i++) {
            for (let z = 0; z < this.wJson[i].columns.length; z++) {
                path = `[${i}]['columns'][${z}]`
                if(this.wJson[i].columns[z].id == rowID){
                    this.wJson[i].columns[z].module.name = module
                    break
                }
            }
        }
    }

    // Wizard objesini oku ve ekrana yazdır
    updatePage(){
        if (localStorage.getItem("Wizard") !== null) {
            const wJson = JSON.parse(localStorage.getItem("Wizard"));
            // Header
            let container = '';
            let columns = '';
            wJson.forEach(w => {
                container = w.fluid==1 ? 'container-fluid' : 'container';
                columns += `<div class="${container}"><div class="row">`;
                w.columns.forEach(c =>{
                    columns += `<div id="${c.id}" class="col-md-${c.col} start">
                        <i class="fas fa-cog" onclick="wizard.setModalID(${c.id})" data-toggle="modal" data-target="#columnModal"></i>
                        <div class="modulename">${c.module.name}</div>
                    </div>`;
                })
                columns += '</div></div>';
            });
            document.getElementById('wizard').innerHTML += columns;
        }
    }

    // Sütün Ekle
    setColumn(ths, args){
        document.querySelectorAll('#column-list li').forEach(li =>{ li.style.background = "" });
        let str = "";
        args.forEach(v =>{ str += v+',' });
        document.querySelector('#columnType').value = str.slice(0, -1);
        ths.style.background = "red";
    }

    // Sütun modal id set et
    setModalID(id){
        document.querySelector('#columnModal').querySelector('input[name=id]').value = id;
    }

    //Modül getir
    async getModule(module){
        let html = "";
        if(module.length){
            let response = await fetch('modules/'+module+'.html');
            html = await response.text();
        }
        return html;
    }
    
    // add html
    async addHtml(){
        const m = document.getElementsByClassName('modulename');
        for (let i = 0; i < m.length; i++) {
           let abc = await this.getModule(m[i].innerHTML)
           m[i].innerHTML = abc
        }
    }


}

const wizard = new Wizard()
