# Pós graduação em Desenvolvimento Web Full-Stack
<p><strong>Professor:</strong> Rodrigo Fujioka.  </p>
<p><strong>Aluno:</strong> Williams Alves Dantas </p>
<p><strong>E-mail:</strong> williamsad9@gmail.com</p>
<p><strong>RGM:</strong> 38441381 </p>

<h1>Descrição do projeto</h1>

<p>Criação de uma API utilizando o framework Springboot para criar um CRUD com objetivo de exercitar os conceitos abordados em sala. Optou-se por criar um CRUD de Ativos financeiros da bolsa de valores.Foi implementados os métodos criar, listar , alterar, excluir e consultar por ID.</p>


<h2>Estrutura de pacotes</h2>
<pre>
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
                        └── exception/
                           
</pre>
 <p></p><strong>br.edu.unipe.api.controller:</strong> Importa o Service e o Model, pois precisa chamar serviços e manipular dados que são retornados ou enviados.</p>
<p></p><strong>br.edu.unipe.api.service:</strong> Importa o Repository, Model, e API Client para realizar operações de banco de dados e integrações externas, além de manipular entidades e exceções específicas que podem ocorrer durante a execução dos métodos de negócios.</p>
<p></p><strong>br.edu.unipe.api.repository:</strong> Importa o Model para definir as entidades do domínio e gerenciar a persistência dos dados no banco de dados H2.</p>
<p><strong>br.edu.unipe.api.model:</strong> Pacote de definição de entidades.</p>
<p><strong>br.edu.unipe.api.exception:</strong> trata todas as exceções personalizadas da aplicação, o que facilita a manutenção e promove a reutilização do código.</p>

<h2>Tratamento de Exceções</h2>
<p>As exceções serão lançadas a partir camada de serviço, por meio da classe "ServiceResponse" que servirá como um contêiner para o resultado do serviço, incluindo o status HTTP e o corpo da resposta que serão repassados ao "AtivoController".</p>
<p>Para situações em que há realmente um erro (por exemplo, uma falha de validação ou uma condição inesperada), o AtivoService ainda pode lançar exceções. Essas exceções podem ser tratadas globalmente usando um Exception Handler.</p>
<p>Essa abordagem mantém o Controller simples, repassando as respostas do Service conforme o status HTTP determinado. Exceções são lançadas apenas para erros reais, mantendo uma separação entre a lógica de negócios e a lógica de controle HTTP.</p>


