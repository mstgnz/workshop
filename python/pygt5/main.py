import sys
from PyQt5 import QtWidgets
from menu import Menu

if __name__ == '__main__':
    app = QtWidgets.QApplication(sys.argv)

    screen = app.primaryScreen()
    rect = screen.availableGeometry()

    menu = Menu(rect.width(), rect.height())
    
    sys.exit(app.exec_())
