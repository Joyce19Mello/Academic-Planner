# Academic Planner

Sistema Web de controle de gestão de atividades para docente/pesquisador.

Um projeto desenvolvido como parte integrante da disicplina GCC209 – Programação Web, ofertada pelo Departamento de Ciência da Computação da Universidade Federal de Lavras.


# Tecnologias Utilizadas

###	Front-end: 
• Vue.js. O Vue é um framework baseado em componentes reativos, usado especialmente para a criação de interfaces web, na maioria das vezes chamadas de SPA - Single Page Application ou aplicações de página única, com somente um arquivo html. Vue.js foi concebido para ser simples, reativo, baseado em componentes, compacto e expansível. 


###	Back-end: 
• Java: Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems. O Java está em todos os lugares!

Escolhemos essa linguagem para o nosso Backend por ser uma linguagem de fácil manuseio e pelo fato de que alguns integrantes do grupo tem familiaridade com a mesma, sendo assim facilitando o desenvolvimento de nosso trabalho prático.

• Play Framework: O Play framework foi construído tendo como um dos intuitos poupar o programador de configurações complicadas, do gerenciamento de arquivos XML, e de boa parte do que se refere a infraestrutura, o mesmo pode se focar mais no core bussiness (parte central de um negócio) da aplicação, com efetivo ganho de qualidade e produtividade.

Além de ser um framework MVC e como isso tornando o desenvolvimento Web muito veloz e divertido.

O Play segue basicamente a seguinte estrutura:
  - app - contém os models, controllers e views do projeto;
  - conf- contém os arquivos de configuração como o arquivo de rotas (routes), configurações gerais da aplicação (application.conf), internacionalização, etc.;
  - project – contém os build scripts do projeto (os scripts são criados para a ferramenta sbt, que é uma ferramenta de build para Scala e Java). Raramente temos que alterá-lo;
  - public – contém recursos como arquivos javascript, css e imagens.

Para esse projeto estamos usando a versão do Play 1.5.1.

• PostgreSQL: PostgreSQL é um sistema gerenciador de banco de dados (SGBD) objeto relacional, desenvolvido como projeto de código aberto. 

Iremos utilizar o Postgre 9.2 como gerenciador do nosso banco de dados. Escolhemos esse ele pois, hoje, o PostgreSQL é um dos SGBDs de código aberto mais avaçados, contando com recursos como:
  - Consultas complexas
  - Chaves estrangeiras
  - Integridade transacional
  - Controle de concorrência multi-versão
  - Suporte ao modelo híbrido objeto-relacional
  - Facilidade de Acesso

# Links

Drive: https://drive.google.com/drive/folders/1vKrCFn5vlJ7NRyeuf0zkG_SKuelQ5qqu

Sitemap: https://www.gloomaps.com/xGeoKoRrtP

# Instalação e Execução

## Comandos para configurar o Frontend

### Instalação

- Instalar o Node.js, disponível no site: https://nodejs.org/en/
  O node é necessário para o uso do comando 'npm' e seus relacionados

### Instalção de dependências do projeto
```
npm install
```

### Compilações e auto-reloads para desenvolvimento
```
npm run serve
```

### Compila para produção
```
npm run build
```

### Executa os testes
```
npm run test
```

### Personalizar a configuração
Olhe em [Referência de configuração](https://cli.vuejs.org/config/).

## Comandos para configurar o Backend


### Convenções de Código

##Comentários de classe obedecerão o seguinte formato:
/*-
 * Classname             (nome da classe Java)
 * 
 * Version information   (versionamento)
 *
 * Date                  (Data e Hora)
 * 
 * author                (autor(res) da criação)
 * Copyright notice      (informações da classe, pra que serve, idéia principal
 */

## Comentários de métodos obedecerão o seguinte formato: 
/*-
 * Copyright notice      (informações do método, pra que serve, idéia principal
 * 
 * @param                 (Parâmetros do método, tipo)
 *
 * @return                (Tipo de retorno do método, significados)
 * 
 */

## Comentários de implementação do código será separado por //
 //comentários.

## Variável será declarada e utilizada seguindo o padrão CamelCase
nomeSobrenome

## Package e Import Statements seguira o seguinte formato:
Primeiro os pacotes e depois os imports em seguida
  package pacote.teste;
  import pacote.teste.Teste;

## Alinhamento do código
  Será iniciado com tab.
  Quando a expressão não couber em uma única linha, quebrá-la da seguinte maneira:
    Após uma vírgula.
    Antes de um operador.

## Classes e Interfaces
Classes Java e interfaces seguem algumas regras de formatação, veja:

  Sem espaço entre um método e o parênteses e o nome do método "(" início de lista de parâmetros;
  Abertura da chaves "{" aparece no fim da mesma linha que foi declarado o código ;
  Fechamento da chaves "}" começa uma linha alinhada no conjunto do método a qual foi criada, exceto quando há códigos em parte em branco(vazio) ou nulo }"devendo aparecer imediatamente depois de aberto com "{"
  Métodos são sempre separados por uma linha em branco.