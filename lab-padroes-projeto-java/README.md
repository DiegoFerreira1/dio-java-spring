# 📘 Anotações sobre Padrões de Projeto em Java e Spring

## ✅ Praticando com Java Puro

### 🔁 Singleton
- **Definição:** Garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.
- **Uso comum:** Gerenciadores de configuração, conexões com banco de dados.
- **Implementação em Java:**
```java
public class Singleton {
    private static Singleton instancia;

    private Singleton() {}

    public static Singleton getInstancia() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }
}
```


### 🧠 Strategy
- **Definição:** Permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis.

- **Uso comum:** Processos com variações de lógica (ex: cálculo de frete, descontos).

- **Implementação em Java:**

```java
public interface Comportamento {
    void mover();
}

public class ComportamentoAgressivo implements Comportamento {
    public void mover() {
        System.out.println("Movendo-se agressivamente...");
    }
}

public class Robo {
    private Comportamento comportamento;

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    public void mover() {
        comportamento.mover();
    }
}
```

### 🎭 Facade
- **Definição:** Fornece uma interface simplificada para um conjunto de interfaces em um subsistema.

- **Uso comum:**  Sistemas complexos com múltiplas dependências.

- **Implementação em Java:**

```java
public class SistemaFacade {
    private ClasseA a;
    private ClasseB b;

    public SistemaFacade() {
        this.a = new ClasseA();
        this.b = new ClasseB();
    }

    public void operacaoFacilitada() {
        a.metodoA();
        b.metodoB();
    }
}
```
## 🌱 Praticando com Spring Framework

### 🔰 Introdução
**Spring:** Framework poderoso para desenvolvimento Java, com suporte a injeção de dependência, MVC, segurança, e muito mais.

**Vantagens:** Menos código *boilerplate*, fácil configuração de *beans*, integração com bancos, REST, etc.

---

### 🔍 Conhecendo o Projeto Base
**Estrutura comum do projeto:**

- `controller/`: Endpoints da API  
- `service/`: Lógica de negócio  
- `repository/`: Acesso a dados  
- `model/`: Entidades  
- `config/`: Configurações gerais (ex: CORS, segurança)

---

### 🧱 Padrões de Projeto em uma API REST com Spring

- **Singleton:** Usado por padrão para beans gerenciados pelo Spring (`@Service`, `@Component`).
- **Strategy:** Implementações injetadas via interfaces (ex: múltiplas estratégias de cálculo).
- **Facade:** Aplicado em serviços que orquestram várias chamadas ou regras de negócio.

---

#### 💡 Exemplo com Spring:

```java
@Service
public class PedidoService {
    private final PagamentoFacade pagamentoFacade;

    public PedidoService(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    public void processarPedido(Pedido pedido) {
        pagamentoFacade.processarPagamento(pedido);
    }
}
```

# 🧩 Resumo de Padrões de Projeto no Spring Framework

## 🔁 Singleton

- **Aplicação no Spring**:
  - Todo bean definido com `@Component`, `@Service`, `@Repository`, ou `@Controller` é **singleton por padrão**.
  - A anotação `@Autowired` injeta essa instância única nos pontos necessários.

- **Exemplo prático**:
  - Um `@Service` de notificação, por exemplo, será instanciado uma única vez e injetado em vários controllers ou serviços.

---

## 🔀 Strategy

- **Aplicação no Spring**:
  - Utilizado com interfaces e múltiplas implementações injetadas via `@Service` ou `@Repository`.
  - O Spring pode escolher a estratégia por nome, perfil, ou lógica dinâmica (ex: via `@Qualifier` ou mapa de beans).

- **Exemplo prático**:
  - Um serviço de pagamento com várias estratégias: `PagamentoCredito`, `PagamentoBoleto`, `PagamentoPix`.
  - Um repositório com várias implementações de acesso a dados (ex: consulta padrão vs. consulta otimizada).

---

## 🎭 Facade

- **Aplicação no Spring**:
  - Um `@Service` que atua como **fachada entre controllers e múltiplos serviços/repositórios**.
  - Simplifica a chamada de múltiplos componentes ao encapsular a lógica de orquestração.

- **Exemplo com Spring Data JPA**:
  - Um `PedidoFacadeService` que chama repositórios do Spring Data JPA como:
    - `PedidoRepository`
    - `ClienteRepository`
    - `EstoqueRepository`
  - O controller chama apenas o método da fachada, enquanto ela realiza as operações necessárias (salvar pedido, atualizar estoque, etc.).
