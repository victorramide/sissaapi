# API REST do projeto SISSA

## Introdução

Olá, tenho pouca criatividade, então criei mais um modo de colocar na prática o projeto SISSA (Sistema de Suporte ao Advogado) que tem como objetivo conectar o Advogado com o Judiciário local. Já fiz esse projeto com <a href="https://github.com/victorramide/sissa">Python/DJANGO</a> e com <a href="https://github.com/victorramide/SISSAJSF">Java/JSF</a> e agora chegou a vez de utilizar o Spring Boot API REST.

>[!OBSERVAÇÃO]
>Esse projeto, assim como os demais citados, tem o objetivo puramente educacional, não tenho permissão do Poder Judiciário para implementar a ferramenta.

## Tecnologias utilizadas e motivação

### Banco de dados H2
Já tive experiência de utilizar o MySQL, MariaDB, PostgreSQL, porém, desta vez escolhi o H2 por nunca ter utilizado durante meus estudos e por ser relativamente mais simples de configurar.

### Linguagem Java e Framework Spring
Não é segredo que eu sou apaixonado por Python, porém também gosto muito de Java e o mercado de trabalho também. Eu tive uma péssima experiência com JSP, mas quando senti a facilidade do Spring eu percebi que valia muito a pena investir tempo estudando suas características.

### API Rest
Quando fui apresentado a essa Arquitetura de Software a minha cabeça explodiu 🤯. Não consigo imaginar o desenvolvimento WEB de outro jeito. Só imagino o tempo que vou economizar quando for estudar Front-end e simplesmente utilizar o JSON gerado por esse projeto para popular o layout. Sensacional!

### IDE IntelliJ
Dentre todas as IDEs que eu testei nessa vida, as produzidas pela JetBrains sem dúvidas são as melhores. A integração com git/github é intuitiva e me faz sentir menos burro em versionamento de código. Atualmente tenho licença de estudante, mas pretendo comprar quando expirar.

### Postman
Ferramenta usada para testar a API, está sendo bem útil aprender como usa-lo.

## Dificuldades

### Listar os Advogados com suas diligências
Ao gerar o Json com os Advogados eu pensei em colocar as diligências que cada um cadastrou junto a seus dados, porém me deparei com um loop infinito de dados, visto que sempre que eu chamava as diligências vinha os dados do Advogado também que por sua vez chamava a diligência novamente. Não sei se fui claro, então lá vai uma imagem:

[Problema na apresentação dos Advogados](docs/001.png)

>[!SOLUÇÃO]A solução foi criar um método em AdvogadoDto para adicionar as diligências manipuladas pela classe DiligenciasDto separadamente, visto que essa não trazia o Advogado inteiro e tão somente uma String. Desta forma consegui adicionar as diligências atráves de um forEach e exibir ao usuário em um formato adequado. O resultado final ficou assim: [Apresentação correta dos Advogados](docs/002.png)

Talvez nesse caso não fosse necessário trazer os dados do Advogado na diligência, visto que já há a vinculação no próprio Advogado, mas para eliminar esse dado eu imagino que seria necessário criar um novo Dto para diligência sem essa informação, o que nesse momento acho desnecessário por se tratar de algo irrisório. (com certeza faria se a regra de negócio fosse rígida nesse sentido).

## Próximo passo
Estou estudando sobre segurança da API, cache e monitoramento e pretendo implementar o que fizer sentido nesse projeto.



