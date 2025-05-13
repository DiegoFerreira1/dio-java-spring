# Santander Dev Week

Java RESTful API 

## Diagrama de classes Mermaid

```mermeid
classDiagram

class Usuario {
    +String name
    +Conta count
    +List~Funcionalidade~ features
    +List~Cartao~ card
    +List~Noticia~ news
}

class Conta {
    +String number
    +String agency
    +Float balance
    +Float limit
}

class Funcionalidade {
    +String icon
    +String description
}

class Cartao {
    +String number
    +String limit
}

class Noticia {
    +String icon
    +String description
}

Usuario --> Conta
Usuario --> Funcionalidade
Usuario --> Cartao
Usuario --> Noticia
```
