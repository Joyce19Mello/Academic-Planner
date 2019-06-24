<template lang="pug">
    #nova-conta
        .informativo-boasVindas
            p.informativo-titulo Cadastro de Nova Conta
        
        form-helper
            div(slot='form-content')
                el-form(ref='form', :model='form', label-width='120px')
                
                    el-col.campo(:span='12')
                        el-form-item(label='Nome Completo')
                        el-input(v-model='form.nome')
                    
                    el-col.campo(:span='12')
                        el-form-item(label='E-mail')
                        el-input(v-model='form.email')
                    
                    el-col.campo(:span='12')
                        el-form-item(label='Sala')
                        el-input(v-model='form.sala')
                    
                    el-col.campo(:span='12')
                        el-form-item(label='Telefone')
                        el-input(v-model='form.telefone')

                    el-col.campo(:span='24')
                    
                        el-form-item(label='Informações profissionais (Formação acadêmica e objetos de estudo)')
                        el-input(type='textarea', v-model='form.informacoes' :autosize='{ minRows: 4, maxRows: 8}')


                    el-col.campo(:span='12')
                        el-form-item(label='Senha')
                        el-input(v-model='form.senha', type="password")

                    el-col.campo(:span='12')
                        el-form-item(label='Confirmar senha')
                        el-input(v-model='form.confirmacaoSenha', type="password")

                    el-col.campo(:span='24')
                        el-form-item
                            el-button( @click='limpar' ) Limpar
                            el-button(type='primary', @click='onSubmit', :disabled="!disabilitarBotao()") Enviar

</template>

<script> 
import FormHelper from '@/components/layouts/FormHelper'
import ProfessorService from '@/services/professorService'

export default {
    name: 'Contato',
    components: FormHelper,
    data(){
        return {
            form: {
                nome: '',
                email: '',
                sala: '',
                telefone: '',
                informacoes: '',
                senha: '',
                confirmacaoSenha: ''
            }
            // ,
            // naoPermiteEnviar: this.verificaEnviar()
        }
    },
    methods: {
        onSubmit() {
            ProfessorService.save('professor/save', this.form)
                .then((result) => {
                    this.$message({
                        showClose: true,
                        message: result.data,
                        type: 'success'
                    });
                })
                .catch((error) => {
                    this.$message({
                        showClose: true,
                        message: error,
                        type: 'warning'
                    });
                });
        },
        limpar() {
            this.form.nome = '';
            this.form.email = '';
            this.form.sala = '';
            this.form.telefone = '';
            this.form.informacoes = '';
            this.form.senha = '';
            this.form.confirmacaoSenha = '';
        },
        disabilitarBotao() {
            if(this.form) {
                return this.form.nome != '' &&
                this.form.email != '' &&
                this.form.sala != '' &&
                this.form.telefone != '' &&
                this.form.informacoes != '' &&
                this.verificarSenhas();
            }
            return false;
        },
        verificarSenhas() {
            if(this.form.senha != '' && this.form.confirmacaoSenha != '' && this.form.senha === this.form.confirmacaoSenha) {
                return true;
            } 
            return false;
        }
    }
}
</script>

<style lang="sass">
#nova-conta
    .informativo-boasVindas
        margin-top: 40px

        .informativo-titulo
            font-size: 40px
            margin: 15px 0 0 0
        
    // .el-form

    //     .campo
    //         padding: 0 40px

    //         .el-form-item
    //             margin-bottom: 0
    //             margin-top: 20px

    //             .el-form-item__label
    //                 text-align: left  
    //                 width: 100% !important

    //             /deep/ .el-form-item__content
    //                 margin-left: 0 !important
    //                 text-align: right

    //         .el-select
    //             width: 100%
    
</style>