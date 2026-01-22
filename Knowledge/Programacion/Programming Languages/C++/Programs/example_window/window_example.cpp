#include <QApplication>
#include <QPushButton>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    QPushButton button("Hola mundo"); // botón con texto
    button.resize(200, 60);           // tamaño
    button.show();                     // mostrar ventana

    return app.exec();                 // loop principal
}