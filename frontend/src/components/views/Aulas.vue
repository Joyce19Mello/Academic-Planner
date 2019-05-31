<template lang="pug">
    #projetos
        .informativo-boasVindas
            p.informativo-titulo Aulas
        
        el-collapse
            el-collapse-item(title='Novo Projeto', name='novoProjeto')
                template(slot="title")

                    el-row.descricao

                        el-col(:span='24').title-collapse Nova Aula

                        el-col(:span='1').icon-cadastrar.lnr.lnr-plus-circle

                form-helper
                    div(slot='form-content')
                        el-form(ref='form', :model='form', label-width='120px')
                            el-col.campo(:span='12')
                                el-form-item(label='Nome da Disciplina')
                                el-input(v-model='form.tituloProjeto',
                                placeholder="ex Português")
                            
                            el-col.campo(:span='12')
                                el-form-item(label='Classificação')
                                el-input(v-model='form.areaEstudo',
                                placeholder="ex Graduação")

                            el-col.campo(:span='6')
                                el-form-item(label='Código da Disciplina')
                                el-input(v-model='form.codigoDisciplina', placeholder="ex GCC-105")
                                                                
                            el-col.campo(:span='24')

                                el-form-item
                                    el-button( @click='limpar' ) Limpar
                                    el-button(type='primary', @click='onSubmit') Cadastrar
             
        el-table(:data='tableData', style='width: 100%')
            el-table-column(prop='codigoDisciplina', label='Código da Disciplina')
            el-table-column(prop='nomeDisciplina', label='Nome da Disciplina')
            el-table-column(prop='classificacao', label='Classificação')
            el-table-column(label='Ações', width='100')
                .lnr.lnr-pencil.editar

</template>

<script>
import FormHelper from '@/components/layouts/FormHelper'
import { AULAS } from '@/utils/mocks/aulas'

export default {
    components: FormHelper,
    name: 'Projetos',
    data(){
        return {
            form: {
                codigoDisciplina: '',
                nomeDisciplina: '',
                classificacao: '',
            },
            tableData: AULAS
        }
    },
    methods: {
        limpar(){
            this.codigoDisciplina = '',
            this.nomeDisciplina = '',
            this.classificacao = ''
        },
        onSubmit() {
            console.log(this.form)
        }
    }
}
</script>

<style lang="sass">
#projetos
    .informativo-boasVindas
        margin-top: 40px

        .informativo-titulo
            font-size: 40px
            margin: 15px 0 0 0
    
    .el-collapse
        border: 1px solid #ddd
        border-radius: 5px
        margin-top: 50px

        .el-collapse-item__arrow
            &:before
                display: none


        .icon-cadastrar
            font-size: 16px
            &:before
                color: #424242
                margin-left: 30px
        
        .title-collapse
            text-align: left
            font-size: 16px

        .descricao
            display: contents
            width: 100%
        
        .el-collapse-item__header
            border-bottom: 1px solid #ddd
            border-radius: 5px
            padding-left: 18px

        .el-collapse-item__wrap
            border-radius: 5px
            border-bottom: solid 1px #ddd
    
    .el-table
        margin-top: 60px
        
        .editar
            font-size: 16px
            cursor: pointer
            margin-left: 12px

            &:hover
                color: #57BC90
</style>