<template lang="pug">
	#projetos
		.informativo-boasVindas
			p.informativo-titulo Alunos
		
		el-collapse
			el-collapse-item(title='Novo Projeto', name='novoProjeto')
				template(slot="title")

					el-row.descricao

						el-col(:span='24').title-collapse Novo Aluno

						el-col(:span='1').icon-cadastrar.lnr.lnr-plus-circle

				form-helper
					div(slot='form-content')
						el-form(ref='form', :model='form', label-width='120px')
							el-col.campo(:span='12')
								el-form-item(label='Nome do aluno')
								el-input(v-model='form.nomeAluno')
							
							el-col.campo(:span='12')
								el-form-item(label='Categoria')
								el-select(v-model='form.categoriaAluno', placeholder='selecione a categoria', value-key="id")
									el-option(v-for='item in categorias', :key='item.id', :label='item.tipoCategoriaAluno', :value='item')


							el-col.campo(:span='6')
								el-form-item(label='Ano de Início da Orientação')
								el-date-picker(v-model="form.dataInicio" 
									placeholder="informe um ano"
									type="year",
									value-format="yyyy")
							
							el-col.campo(:span='6').radio-opcao
								el-checkbox(v-model='form.orientacao' @change="orientacaoClick") Orientação em andamento?
							
							el-col.campo(:span='6')
								el-form-item(label='Ano de Finalização da Orientação')
								el-date-picker(v-model="form.dataFim"
									placeholder="informe um ano"
									type="year",
									value-format="yyyy",
									:disabled="form.orientacao")

							el-col.campo(:span='24')

								el-form-item
									el-button( @click='limpar' ) Limpar
									el-button(type='primary', @click='onSubmit' v-if='!this.form.id') Cadastrar
									el-button(type='primary', @click='onSubmit' v-if='this.form.id') Editar
				
		el-table(:data='tableData', style='width: 100%')
			el-table-column(prop='nomeAluno', label='Nome do Aluno', width='480')
			el-table-column(prop='categoriaAluno.tipoCategoriaAluno', label='Categoria', width='380')
			el-table-column(prop='dataInicio', label='Ano de Inicio', width='180')
			el-table-column(prop='dataFim', label='Ano de Término', width='180')
			el-table-column(label='Ações')
				template(slot-scope="scope")
					.lnr.lnr-pencil.editar(@click="editRow(scope.$index, tableData)")

</template>

<script>
import FormHelper from '@/components/layouts/FormHelper'
// import { PROJETOS } from '@/utils/mocks/projetos'
import AlunoService from '@/services/alunoService'
import CategoriaService from '@/services/categoriaService'

export default {
	components: FormHelper,
	name: 'Alunos',
	data(){
		return {
			form: {
				nomeAluno: '',
				categoriaAluno: '',
				dataInicio: '',
				orientacao: false,
				dataFim: ''
			},
			tableData: [],
			categorias: []
		}
	},
	methods: {
		limpar(){
			this.form.nomeAluno = '',
			this.form.categoriaAluno = '',
			this.form.dataInicio = '',
			this.form.orientacao = false,
			this.form.dataFim = '';
			this.form.id = undefined;
		},
		onSubmit() {
			this.preparaAluno()
			AlunoService.save('aluno/save', this.form)
				.then(result => {
					this.$message({
						showClose: true,
						message: result.data,
						type: 'success'
					})
					this.limpar()
					this.findAlunos()
				})
				.catch((error) => {
					this.$message({
						showClose: true,
						message: error,
						type: 'warning'
					})
				})
		},
		preparaAluno() {
			this.form.professor = {};
			this.form.professor.id = 1;

			if(this.form.orientacao) {
				this.form.dataFim = '-';
			}
		},
		editRow(index, rows) {
			this.form = rows[index];
		},
		findAlunos() {
			AlunoService.listAll('aluno/list', 1)
				.then(result => {
					this.tableData = result.data; 
				});
		},
		findCategorias() {
			CategoriaService.listAll('categoriaAluno/list')
				.then(result => {
					this.categorias = result.data; 
				});
		},
		orientacaoClick() {
			this.form.dataFim = '';
		}
	},
	mounted() {
		this.findAlunos()
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
		
		.radio-opcao    
			margin-top: 80px
	
	.el-table
		margin-top: 60px
		
		.editar
			font-size: 16px
			cursor: pointer
			margin-left: 12px

			&:hover
				color: #57BC90
</style>