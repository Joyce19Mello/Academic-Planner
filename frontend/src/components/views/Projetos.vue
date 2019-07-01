<template lang="pug">
    #projetos
        .informativo-boasVindas
            p.informativo-titulo Projetos
        
        el-collapse
            el-collapse-item(title='Novo Projeto', name='novoProjeto')
                template(slot="title")

                    el-row.descricao

                        el-col(:span='24').title-collapse Novo Projeto

                        el-col(:span='1').icon-cadastrar.lnr.lnr-plus-circle

                form-helper
                    div(slot='form-content')
                        el-form(ref='form', :model='form', label-width='120px')
                            el-col.campo(:span='12')
                                el-form-item(label='Titulo do Projeto')
                                el-input(v-model='form.nomeTituloProjeto')
                            
                            el-col.campo(:span='12')
                                el-form-item(label='Área de Estudo')
                                el-input(v-model='form.areaEstudo')

                            el-col.campo(:span='6')
                                el-form-item(label='Ano de Início')
                                el-date-picker(v-model="form.dataInicio" 
                                    placeholder="informe um ano"
                                    type="year"
                                    value-format="yyyy")
                                    
                            
                            el-col.campo(:span='6')
                                el-form-item(label='Ano de Término')
                                el-date-picker(v-model="form.dataFim"
                                    placeholder="informe um ano"
                                    type="year"
                                    value-format="yyyy")
                            
                            el-col.campo(:span='24')
                            
                                el-form-item(label='Resumo do Projeto')
                                el-input(type='textarea', v-model='form.resumoProjeto' :autosize='{ minRows: 4, maxRows: 8}')

                            el-col.campo(:span='24')

                                el-form-item
                                    el-button( @click='limpar' ) Limpar
                                    el-button(type='primary', @click='onSubmit' v-if='!this.form.id') Cadastrar
                                    el-button(type='primary', @click='onSubmit' v-if='this.form.id') Editar
                
        el-table(:data='tableData', style='width: 100%')
            el-table-column(prop='nomeTituloProjeto', label='Título', width='480')
            el-table-column(prop='areaEstudo', label='Área de Estudo', width='380')
            el-table-column(prop='dataInicio', label='Ano de Inicio', width='180')
            el-table-column(prop='dataFim', label='Ano de Término', width='180')
            el-table-column(label='Ações')
                template(slot-scope="scope")
                    .lnr.lnr-pencil.editar(@click="editRow(scope.$index, tableData)")

</template>

<script>
import FormHelper from '@/components/layouts/FormHelper'
// import { PROJETOS } from '@/utils/mocks/projetos'
import ProjetoService from '@/services/projetoService'

export default {
    components: FormHelper,
    name: 'Projetos',
    data(){
        return {
            form: {
                nomeTituloProjeto: '',
                areaEstudo: '',
                dataInicio: '',
                dataFim: '',
                resumoProjeto: ''
            },
            tableData: []
        }
    },
    methods: {
        limpar(){
            this.form.nomeTituloProjeto = ''
            this.form.areaEstudo = ''
            this.form.dataInicio = ''
            this.form.dataFim = ''
            this.form.resumoProjeto = ''
            this.form.id = undefined
        },
        onSubmit() {
            ProjetoService.save('projeto/save', this.form)
                .then(result => {
                    this.$message({
                        showClose: true,
                        message: result.data,
                        type: 'success'
                    })
                    this.limpar()
                    this.findProjetos()
                })
                .catch((error) => {
                    this.$message({
                        showClose: true,
                        message: error,
                        type: 'warning'
                    })
                })
        },
        findProjetos() {
            ProjetoService.listAll('projeto/list')
                .then(result => {
                    this.tableData = result.data; 
                });
        },
        editRow(index, rows) {
            console.log(rows, index);
            this.form = rows[index];
        }
    },
    mounted () {
        this.findProjetos()
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