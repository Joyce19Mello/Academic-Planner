<template lang="pug">
    #projetos
        .informativo-boasVindas
            p.informativo-titulo Publicações
        
        el-collapse
            el-collapse-item(title='Novo Projeto', name='novoProjeto')
                template(slot="title")

                    el-row.descricao

                        el-col(:span='24').title-collapse Nova Publicação

                        el-col(:span='1').icon-cadastrar.lnr.lnr-plus-circle

                form-helper
                    div(slot='form-content')
                        el-form(ref='form', :model='form', label-width='120px')
                            el-col.campo(:span='12')
                                el-form-item(label='Titulo da Publicação')
                                el-input(v-model='form.tituloProjeto')
                            
                            el-col.campo(:span='6')
                                el-form-item(label='Categoria')
                                el-input(v-model='form.areaEstudo')

                            el-col.campo(:span='6')
                                el-form-item(label='Ano de Publicação')
                                el-date-picker(v-model="form.dataInicio" 
                                    placeholder="informe um ano"
                                    type="year")
                                    
                            
                            el-col.campo(:span='12')
                                el-form-item(label='Projeto Origem')
                                el-input(v-model='form.areaEstudo')
                            
                            el-col.campo(:span='24')
                            
                                el-form-item(label='Resumo da Publicação')
                                el-input(type='textarea', v-model='form.resumoProjeto' :autosize='{ minRows: 4, maxRows: 8}')

                            el-col.campo(:span='24')

                                el-form-item
                                    el-button( @click='limpar' ) Limpar
                                    el-button(type='primary', @click='onSubmit') Cadastrar
                
        el-table(:data='tableData', style='width: 100%')
            el-table-column(prop='tituloProjeto', label='Título', width='480')
            el-table-column(prop='areaEstudo', label='Área de Estudo', width='380')
            el-table-column(prop='dataInicio', label='Ano de Inicio', width='180')
            el-table-column(prop='dataFim', label='Ano de Término', width='180')
            el-table-column(label='Ações')
                .lnr.lnr-pencil.editar

</template>

<script>
import FormHelper from '@/components/layouts/FormHelper'
import { PROJETOS } from '@/utils/mocks/projetos'

export default {
    components: FormHelper,
    name: 'Projetos',
    data(){
        return {
            form: {
                tituloProjeto: '',
                areaEstudo: '',
                dataInicio: '',
                dataFim: '',
                resumoProjeto: ''
            },
            tableData: PROJETOS
        }
    },
    methods: {
        limpar(){
            this.tituloProjeto = '',
            this.areaEstudo = '',
            this.dataInicio = '',
            this.dataFim = '',
            this.resumoProjeto = ''
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