# 📝 Test Kotlin Back-End

### 📦 Dependências usasdas 
**Kotlin:**   
* Jackson Module Kotlin - Interprete que adapta o Jackson para entender os recursos pro Kotlin, permitindo a comunicação entre JSON, Kotlin e Java.
* Kotlin Stdlib - Bibliotecas padrão para trazer funções basicas para aplicações em Kotlin.  
* Kotlin Reflect - Biblioteca padrão de reflexão, necessária para o Spring manipular classes e tempo real. 

**Spring Boot:**  

* Validation - Valida automaticamente os dados em um Controller antes que de sejam iseridas no banco de dados.  
* WEB - É um pacote de ferramentas para projetos APIs REST e projetos WEB.  
* JPA - Intermediador entre sua aplicação e seu banco de dados.  
  
  
**Banco de dados:** <br/> 
*  PostgreSQL    
  
**Programas:**<br/>
* InteliJ  
* PgAdmin4
* Postman  

### 🏗 Arquitetura do Projeto

**/test-kotlin/src/main/kotlin/com.testekotlin.test_kotlin/**  
* 📂 **Configs** → Configurações globais da aplicação<br/>
  * Cors (controle de acesso entre domínios)<br/>
  * Tratamento de erros (Bad Request, validações, etc.)<br/>  
* 📂 **Controladores** → Camada responsável pelos endpoints REST<br/>
  * Implementa o CRUD (Create, Read, Update, Delete)<br/>
  * Recebe as requisições do cliente e retorna as respostas<br/>  
* 📂 **DTOs** → Objetos de Transferência de Dados<br/>  
  * Fazem a comunicação entre a aplicação e os usuários
  * Contêm validações para garantir dados corretos na entrada  
* 📂 **Modelos** → Camada de regra de negócio<br/>
  * Define a estrutura das tabelas (entidades JPA)<br/>
  * Contém os relacionamentos entre objetos<br/>
* 📂 **Repositórios** → Camada de acesso a dados<br/>
  * Responsável pela comunicação com o banco de dados
  * Usa o Spring Data JPA para consultas e persistência

## Funcionalidade
### CRUD MARCAS  
<img width="770" height="798" alt="image" src="https://github.com/user-attachments/assets/87923920-50d7-4904-8e0b-b4a652324c28" />  <br/>
### CRUD MODELOS ManyToOne MARCAS   
<img width="814" height="846" alt="image" src="https://github.com/user-attachments/assets/6b1eb3ce-fe50-47d5-94c1-4b65c8a31460" />  <br/>
### CRUD CARROS ManyToOne MODELOS, com a formatação exigida para o consumo no Front-End
<img width="829" height="871" alt="image" src="https://github.com/user-attachments/assets/6e48e1c7-930f-4948-b427-559dbad52f34" /> <br/>

