class TimeLine{

    constructor(board,scale=50){
        this.board = board;
        this.scale = scale
        this.totalDay = this.totalListHeight = 0;
        this.listWidth = 150;
        this.titleHeight = 50;
        this.defaultListHeight = this.defaultCardHeight = 75;
        this.margin = 5;
        this.boardListHeight = [];
        this.dateLists = [];
        this.minDate = this.maxDate = new Date();
        this.canvasWidth = window.innerWidth;
        this.canvasHeight = window.innerHeight;
        this.columnWidth = 100 * scale / 100; //(this.canvasWidth - this.listWidth) / 31;
        this.init();
    }

    init(){
        this.setMinAndMaxDate();
        const canvas = document.getElementById("timeline");
        canvas.width = this.totalDay * this.columnWidth + this.listWidth * 2;
        canvas.height = this.canvasHeight = this.totalListHeight;
        this.ctx = canvas.getContext("2d");
        this.column();
        this.list();
        this.card();
    }

    column(){
        let offset = this.listWidth;
        this.ctx.lineWidth = 0.05;
        this.ctx.strokeRect(0, 0, 150, this.canvasHeight);
        for (let i = 0; i < this.dateLists.length; i++) {
            // column
            this.ctx.strokeRect(offset, 0, this.columnWidth, this.canvasHeight);
            // text
            this.ctx.font = this.scale < 80 ? "10px Arial" : "14px Arial";
            this.ctx.textAlign = "center";
            //this.ctx.rotate(45 * Math.PI / -90);
            this.ctx.fillText(this.dateLists[i], offset+this.columnWidth/2, 20)
            offset += this.columnWidth;
        }
    }

    list(){
        let offset = this.titleHeight;
        let i = 0;
        Object.keys(this.board).forEach(value => {
            // Box
            this.ctx.fillStyle = i % 2 == 0 ? "#ddd" : "#eee";
            this.ctx.fillRect(0, offset, this.listWidth, this.boardListHeight[i]);
            // Text
            this.ctx.font = "20px Arial";
            this.ctx.textAlign = "left";
            this.ctx.fillStyle = "red";
            this.ctx.fillText(value, 10, offset+30);
            offset += this.boardListHeight[i] + this.margin;
            i ++;
        });
    }

    card(){
        let offsetX = this.columnWidth;
        let offsetY = this.titleHeight;
        let obj,diff,start;
        const lists = Object.values(this.board);
        /* Listeler */
        for (let i = 0; i < lists.length; i++) {
            /* Kartlar */
            for (let j = 0; j < lists[i].length; j++) {
                obj = lists[i][j];
                diff = this.different(obj.startDate, obj.endDate) + 1;
                start = this.totalDay - this.different(this.minDate, obj.startDate);
                // Box
                this.ctx.fillStyle = "#eee";
                this.ctx.fillRect(this.listWidth + start * this.columnWidth, offsetY, diff * this.columnWidth, this.defaultCardHeight);
                // Text
                this.ctx.font = this.scale < 80 ? "10px Arial" : "14px Arial"
                this.ctx.textAlign = "left";
                this.ctx.fillStyle = "red";
                this.ctx.fillText(lists[i][j]['title'], this.listWidth + start * this.columnWidth + 10, offsetY + this.defaultCardHeight / 2);
                obj.assinged.forEach(assign => {
                    //console.log(assign);
                })
                offsetY += this.defaultCardHeight + this.margin;
                offsetX += this.columnWidth;
            }
        }
    }

    setMinAndMaxDate(){
        const lists = Object.values(this.board);
        let obj,year,month,day;
        for (let i = 0; i < lists.length; i++) {
            this.boardListHeight[i] = lists[i].length * this.defaultListHeight + this.margin * (lists[i].length -1);
            this.totalListHeight += this.boardListHeight[i] + this.margin ** 2;
            for (let j = 0; j < lists[i].length; j++) {
                obj = lists[i][j];
                this.minDate = this.minDate > new Date(obj.startDate) ? new Date(obj.startDate) : this.minDate;
                this.maxDate = this.maxDate < new Date(obj.endDate) ? new Date(obj.endDate) : this.maxDate;
            }
        }
        this.totalDay = this.different(this.minDate, this.maxDate) + 1;
        this.setDateList();
    }

    different(startDate, endDate){
        return Math.abs(Math.ceil((new Date(endDate)-new Date(startDate)) / (1000 * 60 * 60 * 24)));
    }

    setDateList(){
        let newDate = this.minDate;
        this.dateLists.push(this.minDate.toLocaleDateString());
        for (let i = 1; i <= this.totalDay; i++) {
            this.dateLists.push(new Date(newDate.setDate(newDate.getDate()+1)).toLocaleDateString())
        }
    }

}

board = {
    "todo": [
        {
            "title" : "Frontend Checkout",
            "startDate": "2021-04-01",
            "endDate": "2021-04-02",
            "assinged" : ["Mesut GENEZ", "Uğur Yıldız"]
        },
        {
            "title" : "Frontend Account",
            "startDate": "2021-04-05",
            "endDate": "2021-04-08",
            "assinged" : ["Uğur Yıldız"]
        },
        {
            "title" : "Sms",
            "startDate": "2021-04-05",
            "endDate": "2021-04-09",
            "assinged" : ["Mesut GENEZ"]
        }
    ],
    "tomade": [
        {
            "title" : "Frontend Checkout",
            "startDate": "2021-04-04",
            "endDate": "2021-04-18",
            "assinged" : ["Mesut GENEZ", "Uğur Yıldız"]
        },
        {
            "title" : "Frontend Account",
            "startDate": "2021-04-10",
            "endDate": "2021-04-18",
            "assinged" : ["Uğur Yıldız"]
        },
        {
            "title" : "Sms",
            "startDate": "2021-04-15",
            "endDate": "2021-04-29",
            "assinged" : ["Mesut GENEZ"]
        },
        {
            "title" : "Frontend Checkout",
            "startDate": "2021-04-24",
            "endDate": "2021-05-03",
            "assinged" : ["Mesut GENEZ", "Uğur Yıldız"]
        }
    ],
    "abc": [
        {
            "title" : "Frontend Account",
            "startDate": "2021-05-02",
            "endDate": "2021-05-10",
            "assinged" : ["Uğur Yıldız"]
        },
        {
            "title" : "Sms",
            "startDate": "2021-05-08",
            "endDate": "2021-05-12",
            "assinged" : ["Mesut GENEZ"]
        }
    ],
    "pool": [
        {
            "title" : "Frontend Checkout",
            "startDate": "2021-04-21",
            "endDate": "2021-05-02",
            "assinged" : ["Mesut GENEZ", "Uğur Yıldız"]
        },
        {
            "title" : "Frontend Account",
            "startDate": "2021-05-05",
            "endDate": "2021-05-12",
            "assinged" : ["Uğur Yıldız"]
        },
        {
            "title" : "Sms",
            "startDate": "2021-05-05",
            "endDate": "2021-05-09",
            "assinged" : ["Mesut GENEZ"]
        }
    ]
}

const timeLine = new TimeLine(board);
