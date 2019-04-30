<template lang="pug">
    .dashboard
        .header
            <table>
                <tr>
                    <th>Academic Planner</th>
                    <th>Projetos</th>
                    <th>Publicações</th>
                    <th>Grupos</th>
                    <th>Alunos</th>
                    <th>Aulas</th>
                    <th>logoff</th>
                </tr>
            </table>
        .background
            // el-carousel(:interval='5000', arrow='always')
                el-carousel-item(v-for='item in 4', :key='item')
                    h3 {{ item }}
            .text
                p {{boasVindas}}

                p {{nameSistema}}
        
        .footer
            p @2019 Ufla - DCC
         
</template>

<script>
    export default {
        name: 'Dashboard',
        data(){
            return {
                boasVindas: "Bem vindo ao",
                nameSistema: "Academic Planner"
            }
        }
    }
</script>

<style lang="sass">
    .header 
        width: 500px;
        margin: auto;
        border: 2px solid;
    
        table.tr.th 
            width: 100px;
        
    .background 
        width: 500px;
        height: 300px;
        border: 2px solid;
        margin: auto;
        background-image: url(../../public/images/plano_fundo_dashboard.jpg);
        background-size: 100% 100%;
        background-repeat: no-repeat;
        opacity: 0.5;
    

    .text 
        width: 150px;
        height: 90px;
        filter: alpha(apacity=60);
        opacity: 0.9;
        border: 1px solid black;
        background-color: #ffffff;
        margin-top: 70px;
        margin-left: 35px;
    

    .p 
        color: #000000;
        fonte-weight: bold;
        margin: 5%;
    

    .footer 
        width: 500px;
        margin: auto;
        border: 2px solid;
    
</style>