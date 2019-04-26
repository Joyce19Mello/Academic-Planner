# Academic Planner

Sistema Web de controle de gestão de atividades para docente/pesquisador.

Um projeto desenvolvido como parte integrante da disicplina GCC209 – Programação Web, ofertada pelo Departamento de Ciência da Computação da Universidade Federal de Lavras.


# Tecnologias Utilizadas

###	Front-end: 
• Vue.js. O Vue é um framework baseado em componentes reativos, usado especialmente para a criação de interfaces web, na maioria das vezes chamadas de SPA - Single Page Application ou aplicações de página única, com somente um arquivo html. Vue.js foi concebido para ser simples, reativo, baseado em componentes, compacto e expansível. 


###	Back-end: 
• Java: Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems. O Java está em todos os lugares!

Escolhemos essa linguagem para o nosso Backend por ser uma linguagem de fácil manuseio e pelo fato de que alguns integrantes do grupo tem familiaridade com a mesma, sendo assim facilitando o desenvolvimento de nosso trabalho prático.

• Play Framework: O Play framework foi construido tendo como um dos intuítos poupar o programador de configurações complicadas, do gerenciamento de arquivos XML, e de boa parte do que se refere a infraestrutura, o mesmo pode se focar mais no core bussiness (parte central de um negócio) da aplicação, com efetivo ganho de qualidade e produtividade.

Além de ser um framework MVC e como isso tornando o desenvolvimento Web muito veloz e divertido.

O Play segue basicamente a seguinte estrutura:
  - app - contêm os models, controllers e views do projeto;
  - conf- contêm os arquivos de configuração como o arquivo de rotas (routes), configurações gerais da aplicação (application.conf), internacionalização, etc.;
  - project – contêm os build scripts do projeto (os scripts são criados para a ferramenta sbt, que é uma ferramenta de build para Scala e Java). Raramente temos que alterá-lo;
  - public – contêm recursos como arquivos javascript, css e imagens.

Para esse projeto estamos usando a versão do Play 1.5.1.


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
