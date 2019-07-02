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
								el-input(v-model='form.nomeDisciplina')
							
							el-col.campo(:span='12')
								el-form-item(label='Classificação')
								el-select(v-model='form.classificacaoAula', placeholder='selecione a classificação', value-key="id")
									el-option(v-for='item in classificacoes', :key='item.id', :label='item.tipoClassificacaoAula', :value='item')

							el-col.campo(:span='6')
								el-form-item(label='Código da Disciplina')
								el-input(v-model='form.codigoDisciplina')
																
							el-col.campo(:span='24')

								el-form-item
									el-button( @click='limpar' ) Limpar
									el-button(type='primary', @click='onSubmit' v-if='!this.form.id') Cadastrar
									el-button(type='primary', @click='onSubmitEdit' v-if='this.form.id') Editar
			 
		el-table(:data='tableData', style='width: 100%')
			el-table-column(prop='codigoDisciplina', label='Código da Disciplina')
			el-table-column(prop='nomeDisciplina', label='Nome da Disciplina')
			el-table-column(prop='classificacaoAula.tipoClassificacaoAula', label='Classificação')
			el-table-column(label='Ações')
				template(slot-scope="scope")
					.lnr.lnr-pencil.editar(@click="editRow(scope.$index, tableData)")

</template>

<script>
import FormHelper from '@/components/layouts/FormHelper'
import CategoriaService from '@/services/categoriaService'
import AulaService from '@/services/aulaService'
// import { AULAS } from '@/utils/mocks/aulas'

export default {
	components: FormHelper,
	name: 'Aulas',
	data(){
		return {
			form: {
				nomeDisciplina: '',
				classificacaoAula: '',
				codigoDisciplina: ''
			},
			tableData: [],
			classificacoes: []
		}
	},
	methods: {
		limpar(){
			this.form.nomeDisciplina = '',
			this.form.classificacaoAula = '',
			this.form.codigoDisciplina = '',
			this.form.id = undefined;
		},
		onSubmit() {
			this.preparaAula()
			AulaService.save('aula/save', this.form)
				.then(result => {
					this.$message({
						showClose: true,
						message: result.data,
						type: 'success'
					})
					this.limpar()
					this.findAulas()
				})
				.catch((error) => {
					this.$message({
						showClose: true,
						message: error,
						type: 'warning'
					})
				})
		},
		onSubmitEdit() {
			this.preparaAula()
			AulaService.edit('aula/edit/' + this.form.id, this.form)
				.then(result => {
					this.$message({
						showClose: true,
						message: result.data,
						type: 'success'
					})
					this.limpar()
					this.findAulas()
				})
				.catch((error) => {
					this.$message({
						showClose: true,
						message: error,
						type: 'warning'
					})
				})
		},
		preparaAula() {
			this.form.professor = {};
			this.form.professor.id = 1;
		},
		editRow(index, rows) {
			this.form = JSON.parse(JSON.stringify(rows[index]));
		},
		findAulas() {
			AulaService.listAll('aula/list', 1)
				.then(result => {
					this.tableData = result.data; 
				});
		},
		findCategorias() {
			CategoriaService.listAll('categoriaAula/list')
				.then(result => {
					this.classificacoes = result.data; 
				});
		},
		orientacaoClick() {
			this.form.dataFim = '';
		}
	},
	mounted() {
		this.findAulas()
		this.findCategorias()
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