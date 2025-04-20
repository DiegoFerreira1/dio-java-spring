# Projeto Springboot - Spring Framework

[Documentação Spring Boot](https://docs.spring.io/spring-boot/documentation.html)

## O que é Springboot
Enquanto o Spring Framework é baseado no padrão de injeção de dependências, o Springboot foca na configuração automática.

### Desafios com a configuração do projeto
- Dependência individual
- Verbosidade
- Incompatibilidade de versões
- Complexidade de gestão
- Configurações complexas e repetitivas

### Proposta do Springboot
Dado que maior parte das configurações necessárias para o início de um projeto são sempre as mesmas, por que não iniciar um projeto com todas as configurações ja definidas?

- Aumenta a produtividade
- O desenvolvedor foca nas regras de negócio

## Starters
Os SpringBoot Starters são um conjunto prático de descritores de dependências que você pode incluir em sua aplicação. Você obtém um único local para todo o Spring e tecnologias relacionadas que precisa, sem precisar vasculhar códigos de exemplo e copiar e colar vários descritores de dependências. 

Por exemplo, se você quiser começar a usar Spring e JPA para acesso a bancos de dados, inclua a `spring-boot-starter-data-jpadependência` em seu projeto e pronto.

### Benefícios
- Coesão
- Versões compatíveis
- Otimização do tempo
- Configuração simples
- Foco no negócio

### Starters mais utilizados
> Spring-boot-starter-*

- **datajpa**: Integração ao banco de dados via JPA - Hibernate
- **data-mongoldb**: Interação com o banco de dados MongolDB
- **web**: Inclusão do container Tomcat para aplicações REST
- **web-services**: Webservices baseados na arquitetura SOPA

- Configurações manuais
- Principais Starters
- Configuração de fábrica

# Criando projeto springboot

## Diferença de criaçção de objetos Springboot e java convencional
### 🟡 Java Convencional
### No Java tradicional, você mesmo é responsável por instanciar os objetos:

```java
MeuServico servico = new MeuServico();
```
- O programador cria os objetos manualmente com new.
- O controle de dependências e do ciclo de vida é manual.
- O acoplamento entre classes costuma ser maior.
- 
### 🟢 Spring Boot
No Spring Boot (e no Spring em geral), o Spring é quem gerencia os objetos, graças ao mecanismo de Inversão de Controle (IoC) e Injeção de Dependência (DI).
````java
@Service
public class MeuServico {
    public void executar() {
        System.out.println("Executando serviço...");
    }
}

@RestController
public class MeuController {

    @Autowired
    private MeuServico servico;

    @GetMapping("/executar")
    public String executar() {
        servico.executar();
        return "OK";
    }
}
```

| Aspecto                  | Java Convencional                | Spring Boot                          |
|--------------------------|----------------------------------|--------------------------------------|
| Criação de objetos       | Manual (`new`)                   | Automática pelo container do Spring  |
| Injeção de dependência   | Manual                           | Automática (`@Autowired`)            |
| Ciclo de vida do objeto  | Manual                           | Gerenciado pelo Spring               |
| Escopo dos objetos       | Fixo (variável local ou global)  | Configurável (`@Scope`)              |
| Acoplamento              | Alto                             | Baixo (graças à injeção de dependência) |
