<template lang="pug">
    .card
        el-card.box-card
            .icon.lnr.lnr-user
            .dados
                span.informativo-funcoes-texto.titulo nome: 
                span.informativo-funcoes-texto {{professor.nome}}
            .dados    
                span.informativo-funcoes-texto.titulo sala: 
                span.informativo-funcoes-texto {{professor.sala}}
            .dados
                span.informativo-funcoes-texto.titulo telefone: 
                span.informativo-funcoes-texto {{professor.telefone}}
            .dados
                span.informativo-funcoes-texto.titulo email: 
                span.informativo-funcoes-texto {{professor.email}}
            el-collapse.descricao
                el-collapse-item(name="1")
                    div.descricao-texto
                        span {{professor.informacoesProfissionais}}
                    
                    a.entrar-contato(href='#/contato' @click='entrarContato()') Entrar em contato
         
</template>

<script>
import RouterMixin from '@/utils/mixins/RouterMixin'

export default {
    name: 'Card',
    mixins: [RouterMixin],
    props: ['professor'],
    data(){
        return {
        }
    },
    methods: {
        entrarContato() {
            this.goTo('contato')
        }
    }
}
</script>

<style lang="sass">
.card
            
    .box-card
        width: 90%
        display: inline-block
        margin-bottom: 40px

        .descricao
            border: none

            /deep/ .el-collapse-item__header
                border: none
            
            /deep/ .el-collapse-item__wrap
                border: none
            
            .descricao-texto
                margin-bottom: 20px
            
            .entrar-contato
                font-size: 15px

    .icon
        font-weight: bold
        font-size: 80px
        margin: 10px 0 25px 0
    
    .dados
        display: -webkit-box

        .titulo
            font-weight: bold

        .informativo-funcoes-texto
            display: block
            text-align: left
            margin: 2px 5px

            // &:hover
            //     color: #015249
            //     border: 2px solid #77C9D4
            //     border-radius: 10px
            //     margin-top: -2px
                
            //     .icon
            //         font-size: 135px
                
            //     .informativo-funcoes-texto
            //         width: 70%
            //         display: inline-block
            //         margin-top: 50px
            //         font-size: 18px
    
</style>