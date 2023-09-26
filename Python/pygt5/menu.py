from PyQt5 import QtWidgets
from form import Form

class Menu(QtWidgets.QMainWindow):

    def __init__(self, screenWidth, screenHeight):
        super().__init__()

        self.screenWidth = screenWidth
        self.screenHeight = screenHeight
        self.form = Form()
        self.setCentralWidget(self.form)
        self.statusBar().showMessage('Ready')
        self.setWindowTitle("Öğrenci Bilgileri")
        self.createMyMenu()
        self.center()
        self.show()

    def createMyMenu(self):
        menubar = self.menuBar()
        menubar.setNativeMenuBar(False) # macos system needed for show menu bar

        dosya = menubar.addMenu("Dosya")

        dosyaAc = QtWidgets.QAction("Dosya Aç", self)
        dosyaKaydet = QtWidgets.QAction("Dosya Kaydet", self)
        cikis = QtWidgets.QAction("Çıkış", self)

        dosya.addAction(dosyaAc)
        dosya.addAction(dosyaKaydet)
        dosya.addAction(cikis)
    
    def center(self):
        self.setFixedSize(600,600)
        width = self.frameGeometry().width()
        height = self.frameGeometry().height()
        self.setGeometry((self.screenWidth/2)-(width/2), (self.screenHeight/2)-(height/2), width, height)
