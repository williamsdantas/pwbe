# Pós graduação em desenvolvimento web full-stack
Professor: Rodrigo Fujioka. 
Aluno: Williams Alves Dantas
Matricula: 

<h1>Descrição do projeto</h1>

<p>Criação de uma API utilizando o framework Springboot para criar um CRUD com objetivo de exercitar os conceitos abordados em sala. Optou-se por criar um CRUD de Ativos financeiros da bolsa de valores.Foi implementados os métodos criar, listar , alterar, excluir e consultar por ID.</p>


<h2>Estrutura de pacotes</h2>

src/
└── main/
    └── java/
        └── br/
            └── edu/
                └── unipe/
                    └── api/
                        ├── controller/
                           |--- AtivoController.java
                        ├── service/
                           |--- AtivoService.java
                           |--- ServiceResponse.java
                        ├── repository/
                           |--- AtivoRepository.java
                        ├── model/
                           |--- Ativo.java
                           |---DadosListagemAtivos.java
                        ├── client/
                        └── exception/
                           

<strong>br.edu.unipe.api.controller:</strong> Importa o Service e o Model, pois precisa chamar serviços e manipular dados que são retornados ou enviados.
<strong>br.edu.unipe.api.service:</strong> Importa o Repository, Model, e API Client para realizar operações de banco de dados e integrações externas, além de manipular entidades e exceções específicas que podem ocorrer durante a execução dos métodos de negócios.
<strong>br.edu.unipe.api.repository:</strong> Importa o Model para definir as entidades do domínio e gerenciar a persistência dos dados.
<strong>br.edu.unipe.api.model:</strong> Não precisa importar outros pacotes, pois é um pacote de definição de entidades.
<strong>br.edu.unipe.api.client:</strong> Pode usar bibliotecas como RestTemplate para comunicação com APIs externas, mas neste diagrama, não estamos mostrando imports específicos de bibliotecas externas.
<strong>br.edu.unipe.api.exception:</strong> trata todas as exceções personalizadas da aplicação, o que facilita a manutenção e promove a reutilização do código.

<h2>Tratamento de Exceções</h2>
<p>As exceções serão lançadas a partir camada de serviço, por meio da classe "ServiceResponse" que servirá como um contêiner para o resultado do serviço, incluindo o status HTTP e o corpo da resposta que serão repassados ao "AtivoController".</p>
<p>Para situações em que há realmente um erro (por exemplo, uma falha de validação ou uma condição inesperada), o AtivoService ainda pode lançar exceções. Essas exceções podem ser tratadas globalmente usando um Exception Handler.</p>


