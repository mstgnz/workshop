from PyQt5 import QtWidgets
import db

class Form(QtWidgets.QWidget):
    

    def __init__(self):
        super().__init__()
        self.init_ui()
        self.ID = 0


    def init_ui(self):
        vBox = QtWidgets.QVBoxLayout()
        vBox.addLayout(self.formBox())
        vBox.addStretch()
        vBox.addLayout(self.listBox())
        vBox.addStretch()
        vBox.addLayout(self.btnBox())

        self.setLayout(vBox)


    def btnBox(self):
        selectBtn = QtWidgets.QPushButton("Listele")
        recordBtn = QtWidgets.QPushButton("Kaydet")
        deleteBtn = QtWidgets.QPushButton("Sil")
        updateBtn = QtWidgets.QPushButton("Güncelle")

        hBox = QtWidgets.QHBoxLayout()
        hBox.addWidget(selectBtn)
        hBox.addWidget(recordBtn)
        hBox.addWidget(deleteBtn)
        hBox.addWidget(updateBtn)

        # if use function params connect(lambda: self.click(params))
        # if not use function params connect(self.click)
        selectBtn.clicked.connect(self.click)
        recordBtn.clicked.connect(self.click)
        deleteBtn.clicked.connect(self.click)
        updateBtn.clicked.connect(self.click)

        return hBox


    def click(self):
        sender = self.sender()
        sender = sender.text()
        if sender == "Listele":
            self.formList()
        elif sender == "Kaydet":
            self.formSave()
        elif sender == "Sil":
            self.formDelete()
        else:
            self.formUpdate()


    def formBox(self):
        isimLbl = QtWidgets.QLabel()
        isimLbl.setText("Ad Soyad")
        isimLbl.setStyleSheet("padding:3px")
        self.isimLe = QtWidgets.QLineEdit()
        self.isimLe.setStyleSheet("padding:3px")

        sinifLbl = QtWidgets.QLabel()
        sinifLbl.setText("Sınıf")
        sinifLbl.setStyleSheet("padding:3px")
        self.sinifLe = QtWidgets.QLineEdit()
        self.sinifLe.setStyleSheet("padding:3px")

        alanLbl = QtWidgets.QLabel()
        alanLbl.setText("Alan")
        alanLbl.setStyleSheet("padding:3px")
        self.alanLe = QtWidgets.QLineEdit()
        self.alanLe.setStyleSheet("padding:3px")

        emailLbl = QtWidgets.QLabel()
        emailLbl.setText("Email")
        emailLbl.setStyleSheet("padding:3px")
        self.emailLe = QtWidgets.QLineEdit()
        self.emailLe.setStyleSheet("padding:3px")

        grid = QtWidgets.QGridLayout()
        grid.setSpacing(10)

        grid.addWidget(isimLbl, 1, 0)
        grid.addWidget(self.isimLe, 1, 1)

        grid.addWidget(sinifLbl, 2, 0)
        grid.addWidget(self.sinifLe, 2, 1)

        grid.addWidget(alanLbl, 3, 0)
        grid.addWidget(self.alanLe, 3, 1)

        grid.addWidget(emailLbl, 4, 0)
        grid.addWidget(self.emailLe, 4, 1)

        return grid

    def listBox(self):

        self.table = QtWidgets.QTreeWidget()
        self.table.setHeaderLabels(['ID','Ad Soyad', 'Sınıf', 'Alan', 'Email'])
        
        self.table.itemDoubleClicked.connect(self.onItemClicked)

        hBox = QtWidgets.QHBoxLayout()
        hBox.addWidget(self.table)

        return hBox

    def onItemClicked(self, item, col):
        self.ID = int(item.text(0))
        self.isimLe.setText(item.text(1))
        self.sinifLe.setText(item.text(2))
        self.alanLe.setText(item.text(3))
        self.emailLe.setText(item.text(4))

    def formSave(self):
        isim = self.isimLe.text()
        sinif = self.sinifLe.text()
        alan = self.alanLe.text()
        email = self.emailLe.text()

        if isim and sinif and alan and email:
            db.fetchOne("insert into ogrencibilgi (isim,sinif,alan,email) values ('{}','{}','{}','{}')".format(isim,sinif,alan,email))
            self.formList()
        else:
            QtWidgets.QMessageBox.critical(self, "HATA", "Tüm alanlar zorunludur ve doldurmanız gerekmektedir!")

    def formDelete(self):
        if(self.ID):
            db.fetchOne("delete from ogrencibilgi where id={}".format(self.ID))
            self.formList()
        else:
            QtWidgets.QMessageBox.critical(self, "HATA", "ID bulunamadı!")
        self.ID = 0

    def formUpdate(self):
        isim = self.isimLe.text()
        sinif = self.sinifLe.text()
        alan = self.alanLe.text()
        email = self.emailLe.text()

        if isim and sinif and alan and email and self.ID:
            db.fetchOne("update ogrencibilgi set isim='{}', sinif='{}', alan='{}', email='{}' where id={}".format(isim,sinif,alan,email,self.ID))
            self.formList()
        else:
            QtWidgets.QMessageBox.critical(self, "HATA", "Tüm alanlar zorunludur ve doldurmanız gerekmektedir!")
        self.ID = 0


    def formList(self):
        self.formClear()
        dataList = db.fetchAll("select * from ogrencibilgi")
        for data in dataList:
            QtWidgets.QTreeWidgetItem(self.table, [str(data[0]), data[1], data[2], data[3], data[4]])

    def formClear(self):
        self.table.clear()
        self.isimLe.clear()
        self.sinifLe.clear()
        self.alanLe.clear()
        self.emailLe.clear()
