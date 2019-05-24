<template lang="pug">
#login
    p.informativo-titulo Autenticação


    form-helper
        div(slot='form-content')

            el-form(ref='form', :model='form', label-width='120px')
                el-row(:gutter="20")
                    el-col.campo(:span='8', :offset="8")
                        el-form-item(label='Email')
                        el-input(v-model='form.email')

                el-row(:gutter="20")
                    el-col.campo(:span='8', :offset="8")
                        el-form-item(label='Senha')
                        el-input(v-model='form.senha')
                
                el-row(:gutter="20")
                    el-col.campo.alinhar-esquerda(:span='8', :offset="8")
                        a.link(href='#/login' @click='esqueceuSenha') Recuperar senha

                el-row(:gutter="20")
                    el-col.campo(:span='8', :offset="8")

                        el-form-item
                            el-button(type='primary', @click='onSubmit') Enviar
                el-row(:gutter="20")
                    el-col.campo(:span='8', :offset="8")
                        a.link(href='#/nova-conta' @click='criarConta') Criar conta
</template>

<script>
import FormHelper from '@/components/layouts/FormHelper'
import RouterMixin from '@/utils/mixins/RouterMixin'

export default {
    name: 'Login',
    components: FormHelper,
    mixins: [RouterMixin],
    data() {
        return{
            form: {
                email: '',
                senha: ''
            }
        }
    },
    methods: {
        esqueceuSenha() {
            console.log("vai recuperar")
        //   this.goTo('recuperarSenha')
        },
        criarConta () {
            console.log("vai Criar")
        //   this.goTo('criarConta')
        },
        onSubmit () {
            this.$bus.$emit('logar')
            this.goToDashboard()
        }
    }
}
</script>

<style lang="sass">
.informativo-titulo
    font-size: 40px
    margin: 55px 0 0 0

// .el-form

//     .campo
//         padding: 0 40px

//         .el-form-item
//             margin-bottom: 0
//             margin-top: 20px

//             .el-form-item__label
//                 text-align: left
//                 width: 100% !important
            
// /deep/ .el-form-item__content
//     margin-left: 0 !important
//     text-align: center

//         .el-select
//             width: 100%

//         .link
//             font-size: 15px

//     .alinhar-esquerda
//         text-align: left
</style>
