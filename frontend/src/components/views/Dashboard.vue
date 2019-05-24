<template lang="pug">
    #dashboard
        div(v-if='!usuarioLogado')
            .informativo-boasVindas
                p.informativo-titulo Sua plataforma de gestão
                p.informativo-titulo e apoio às atividades universitárias.
            
            el-row.informativo-sistema

                el-col.informativo-funcoes( :span='8')
                    .icon.lnr.lnr-magnifier
                    p.informativo-funcoes-texto 
                        | Controle das atividades de pesquisa de graduação e pós-graduação
                
                el-col.informativo-funcoes( :span='8')
                    .icon.lnr.lnr-graduation-hat
                    p.informativo-funcoes-texto 
                        | Gestão dos alunos orientados e das aulas ministradas
                
                el-col.informativo-funcoes( :span='8')
                    .icon.lnr.lnr-book
                    p.informativo-funcoes-texto 
                        | Organização de publicações em conferências, resumos e periódicos
        
        div(v-if='usuarioLogado')
            p TUTS

         
</template>

<script>
    export default {
        name: 'Dashboard',
        data(){
            return {
                usuarioLogado: false
            }
        },
        mounted() {
            this.$bus.$on('loga', () => this.logar())
            this.$bus.$on('logou', () => this.logout())
        },
        methods: {
            logar () {
                console.log("HERERERE")
                this.usuarioLogado = true
            },
            logout () {
                this.usuarioLogado = false
            }
        }

    }
</script>

<style lang="sass">
#dashboard
    .informativo-boasVindas
        margin-top: 40px

        .informativo-titulo
            font-size: 40px
            margin: 15px 0 0 0
        
    .informativo-sistema
        margin-top: 50px

        .informativo-funcoes
            color: #A5A5Af

            .icon
                font-weight: bold
                font-size: 100px
                margin-top: 50px

            &:hover
                color: #015249
                border: 2px solid #77C9D4
                border-radius: 10px
                margin-top: -2px
                
                .icon
                    font-size: 135px
                
                .informativo-funcoes-texto
                    width: 70%
                    display: inline-block
                    margin-top: 50px
                    font-size: 18px
    
</style>