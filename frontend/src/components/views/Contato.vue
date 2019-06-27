<template lang="pug">
    #contato
        .informativo-boasVindas
            p.informativo-titulo Contato
        
        .form-helper
            div(slot='form-content')
                el-form(ref='form', :model='form', label-width='120px')
                    el-col.campo(:span='12')
                        el-form-item(label='Nome Completo')
                        el-input(v-model='form.nome')
                    
                    el-col.campo(:span='12')
                        el-form-item(label='E-mail')
                        el-input(v-model='form.email')
                    
                    el-col.campo(:span='12')

                        el-form-item(label='Professor')
                        el-select(v-model='form.professor', placeholder='Selecione o professor que receberá o contato', value-key="id")
                            el-option(v-for='professor in professores' :key='professor.id' :label='professor.nome' :value='professor')
                    
                    el-col.campo(:span='12')
                        el-form-item(label='Assunto')
                        el-input(v-model='form.assunto')
                    
                    el-col.campo(:span='24')
                    
                        el-form-item(label='Mensagem')
                        el-input(type='textarea', v-model='form.mensagem' :autosize='{ minRows: 4, maxRows: 8}')

                    el-col.campo(:span='24')

                        el-form-item
                            el-button( @click='limpar' ) Limpar
                            el-button(type='primary', @click='onSubmit') Enviar
        
</template>

<script>
// import { PROFESSORES } from '@/utils/mocks/professores'
import FormHelper from '@/components/layouts/FormHelper'
import ProfessorService from '@/services/professorService'
import ContatoService from '@/services/contatoService'

export default {
name: 'Contato',
components: FormHelper,
    data(){
        return {
            professores: {},
            form: {
                nome: '',
                email: '',
                professor: {},
                assunto: '',
                mensagem: ''
            }
            // ,
            // naoPermiteEnviar: this.verificaEnviar()
        }
    },
    methods: {
        onSubmit() {
            ContatoService.contact('contato/contact', this.form)
                .then((response) => {
                    this.$message({
                        showClose: true,
                        message: response.data,
                        type: 'success'
                    });
                    this.limpar();
                });
        },
        limpar() {
            this.form.nome = '';
            this.form.email = '';
            this.form.prof = {};
            this.form.assunto = '';
            this.form.mensagem = '';
        }
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
    },
    mounted() {
        ProfessorService.listAll('professor/list')
            .then(result => {
                this.professores = result.data; 
            });
    }
}
</script>

<style lang="sass">
#contato
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