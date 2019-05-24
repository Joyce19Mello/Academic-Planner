<template lang="pug">
    #form-helper        
        
        slot(name="form-content")
            
        //-     el-col.campo(:span='12')
        //-         el-form-item(label='Nome Completo')
        //-         el-input(v-model='form.nome')
            
        //-     el-col.campo(:span='12')
        //-         el-form-item(label='E-mail')
        //-         el-input(v-model='form.email')
            
        //-     el-col.campo(:span='12')
        //-         el-form-item(label='Sala')
        //-         el-input(v-model='form.sala')
            
        //-     el-col.campo(:span='12')
        //-         el-form-item(label='Telefone')
        //-         el-input(v-model='form.telefone')

        //-     el-col.campo(:span='24')
            
        //-         el-form-item(label='Informações profissionais (Formação acadêmica e objetos de estudo)')
        //-         el-input(type='textarea', v-model='form.informacoes' :autosize='{ minRows: 4, maxRows: 8}')


        //-     el-col.campo(:span='12')
        //-         el-form-item(label='Senha')
        //-         el-input(v-model='form.senha', type="password")

        //-     el-col.campo(:span='12')
        //-         el-form-item(label='Confirmar senha')
        //-         el-input(v-model='form.confirmacaoSenha', type="password")

        //-     el-col.campo(:span='24')
        //-         el-form-item
        //-             el-button( @click='limpar' ) Limpar
        //-             el-button(type='primary', @click='onSubmit') Enviar

</template>

<script>

export default {
    name: 'FormHelper',
    data(){
        return {
            // form: {
            //     nome: '',
            //     email: '',
            //     sala: '',
            //     telefone: '',
            //     informacoes: '',
            //     senha: '',
            //     confirmacaoSenha: ''
            // }
            // ,
            // naoPermiteEnviar: this.verificaEnviar()
        }
    },
    methods: {
        // onSubmit() {
        //     console.log(this.form)
        // },
        // limpar() {
        //     this.form.nome = '';
        //     this.form.email = '';
        //     this.form.sala = '';
        //     this.form.telefone = '';
        //     this.form.informacoes = '';
        //     this.form.senha = '';
        //     this.form.confirmacaoSenha = '';
        // }
        // ,
        // verificaEnviar() {
        //     if(this.form) {
        //         return !this.form.nome &&
        //         !this.form.email &&
        //         !this.form.prof &&
        //         !this.form.assunto &&
        //         !this.form.mensagem
        //     } else {
        //         return false
        //     }
        // }
    }
}
</script>

<style lang="sass">
// #form-helper
        
.el-form

    .campo
        padding: 0 40px

        .el-form-item
            margin-bottom: 0
            margin-top: 20px

            .el-form-item__label
                text-align: left  
                width: 100% !important

            /deep/ .el-form-item__content
                margin-left: 0 !important
                text-align: center
                margin-bottom: 10px

        .el-select
            width: 100%

        .link
            font-size: 15px

    .alinhar-esquerda
        text-align: left
    
</style>