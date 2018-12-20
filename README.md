## Introdução

Este repositório contem uma implementação de referência para auxiliar na conclusão do exercício descrito nas próximas seções. Esta implementação de referência contem todas as configurações necessárias para o candidato concluir o exercício.

O candidato DEVE realizar o clone da branch master, criar uma nova branch, realizar a implementação e para a entrega fazer o push e solicitar um pull request para a master.
- Padrão de nome da branch: `ft-yyyyMMdd-nome-completo`

## Diagrama de atividades

O diagrama abaixo representa as atividades na implementação de um recurso REST de operação POST para manipulação de determinada representação (entidade carro, por exemplo).

<p align="center">
  <img src="https://user-images.githubusercontent.com/33067041/50282525-2b257480-043a-11e9-92a0-243ca77cdfd9.png">
</p>

## Entidades

O modelo abaixo DEVE ser utilizado para o desenvolvimento do exercício. Esta é uma estrutura base, sendo permitido ao candidato incrementar ou não este modelo.

<p align="center">
  <img src="https://user-images.githubusercontent.com/33067041/50282965-958ae480-043b-11e9-8112-7073163aef0d.png">
</p>

## Exercício

Utilizando a implementação de referência, o diagrama de atividades e as entidades definidas como base para implementação do exercício, o candidato DEVE seguir as seguintes definições:

* A aplicação DEVE ser desenvolvida utilizando a abordagem [API-First](https://swagger.io/resources/articles/adopting-an-api-first-approach/) com a especificação [OpenAPI 2.0 - Swagger](https://swagger.io/docs/specification/2-0/what-is-swagger/). Ou seja, o primeiro passo DEVE ser a criação de um arquivo YAML com a descrição da API com as operações e objetos que a aplicação irá suportar.
* A aplicação DEVE conter a implementação de todas as operações CRUD, ou seja, POST para criar, GET para ler, PUT e/ou PATH para atualizar e DELETE para remover. Apenas a entidade _carro_ DEVE ter as operações CRUD implementadas, as demais podem ser trabalhadas com cargas iniciais.
  * **Notas**:
    * No estilo RESTful o PUT é utilizado para realizar uma atualização completa na entidade e o PATH para atualizações parciais. A atualização em si no estilo RESTful envolve algumas técnicas mais complexas, mas para este exercício o candidato poderá optar por qualquer um dos verbos sem se preocupar com essas complexidades, apenas em realizar a operação de UPDATE.
    * A implementação de referência utiliza o H2 como banco de dados e possui exemplo de carga inicial. A utilização do H2 DEVE ser mantida.
* A representação de resposta dos recursos da API DEVE conter atributos não existentes nas entidades do banco de dados, ou seja atributos calculados.
* A aplicação DEVE conter testes unitários.
* A aplicação DEVE ser desenvolvida utilizando recursos do Java 8 sempre que possível.
•	A implementação DEVE ser entregue em no máximo **4 dias corridos** após o recebimento do exercício.
* A aplicação NÃO DEVE conter UI (User Interface), apenas o back-end (API).
* A aplicação PODE conter recursos/implementações adicionais, caso o candidato tenha interesse **(diferencial)**.
* A implementação PODE ser entregue com diagramas de atividades das operações **(diferencial)**.

## Importante

* A aplicação será avaliada no commit/push do pull request mais próximo do prazo de término para a conclusão do exercício.
* A aplicação será analisada através do SonarQube. É recomendado a utilização do plugin [SonarLint](https://www.sonarlint.org/) para análise das métricas do SonarQube.
* A aplicação será analisada em relação a cobertura de testes. É recomendado a utilização de algum plugin de análise de cobertura (exemplo o [EclEMMA](https://www.eclemma.org/) para Eclipse).

## Dúvidas

* Caso o candidato conclua a implementação antes do prazo definido, poderá enviar um email para [gp@grupomult.com.br](mailto:gp@grupomult.com.br) com cópia para [lancer.castro@grupomult.com.br](mailto:lancer.castro@grupomult.com.br) notificando a conclusão do exercício.
* O candidato PODE entrar em contato através do email [gp@grupomult.com.br](mailto:gp@grupomult.com.br) para qualquer dúvida sobre o processo.
* O candidato PODE entrar em contato através do email [lancer.castro@grupomult.com.br](mailto:lancer.castro@grupomult.com.br) para qualquer dúvida sobre o exercício.
