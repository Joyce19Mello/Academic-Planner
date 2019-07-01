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
								el-input(v-model='form.nomeTituloPublicacao')
							
							el-col.campo(:span='6')
								el-form-item(label='Categoria')
								el-select(v-model='form.categoriaPublicacao', placeholder='selecione a categoria', value-key="id")
									el-option(v-for='item in categorias', :key='item.id', :label='item.tipoCategoriaPublicacao', :value='item')

							el-col.campo(:span='6')
								el-form-item(label='Ano de Publicação')
								el-date-picker(v-model="form.anoPublicacao" 
									placeholder="informe um ano"
									type="year",
									value-format="yyyy")
									
							
							el-col.campo(:span='12')
								el-form-item(label='Projeto Origem')
								el-select(v-model='form.projeto', placeholder='selecione o projeto', value-key="id")
									el-option(v-for='item in projetos', :key='item.id', :label='item.nomeTituloProjeto', :value='item')

								
							
							el-col.campo(:span='24')
							
								el-form-item(label='Resumo da Publicação')
								el-input(type='textarea', v-model='form.resumoPublicacao' :autosize='{ minRows: 4, maxRows: 8}')

							el-col.campo(:span='24')

								el-form-item
									el-button( @click='limpar' ) Limpar
									el-button(type='primary', @click='onSubmit' v-if='!this.form.id') Cadastrar
									el-button(type='primary', @click='onSubmit' v-if='this.form.id') Editar
				
		el-table(:data='tableData', style='width: 100%')
			el-table-column(prop='nomeTituloPublicacao', label='Título', width='480')
			el-table-column(prop='categoriaPublicacao.tipoCategoriaPublicacao', label='Categoria', width='380')
			el-table-column(prop='projeto.nomeTituloProjeto', label='ProjetoOrigem', width='180')
			el-table-column(prop='anoPublicacao', label='Ano', width='180')
			el-table-column(label='Ações')
				template(slot-scope="scope")
					.lnr.lnr-pencil.editar(@click="editRow(scope.$index, tableData)")

</template>

<script>
import FormHelper from '@/components/layouts/FormHelper'
// import { PROJETOS } from '@/utils/mocks/projetos'
import ProjetoService from '@/services/projetoService'
import PublicacaoService from '@/services/publicacaoService'
import CategoriaService from '@/services/categoriaService'

export default {
	components: FormHelper,
	name: 'Publicacoes',
	data(){
		return {
			form: {
				nomeTituloPublicacao: '',
				projeto: '',
				anoPublicacao: '',
				categoriaPublicacao: '',
				resumoPublicacao: ''
			},
			tableData: [],
			projetos: [],
			categorias: []
		}
	},
	methods: {
		limpar(){
			this.form.nomeTituloPublicacao = '';
			this.form.projeto = {};
			this.form.anoPublicacao = '';
			this.form.categoriaPublicacao = {};
			this.form.resumoPublicacao = '';
			this.form.id = undefined;
		},
		onSubmit() {
			PublicacaoService.save('publicacao/save', this.form)
				.then(result => {
					this.$message({
						showClose: true,
						message: result.data,
						type: 'success'
					})
					this.limpar()
					this.findPublicacoes()
				})
				.catch((error) => {
					this.$message({
						showClose: true,
						message: error,
						type: 'warning'
					})
				})
		},
		editRow(index, rows) {
			console.log(rows, index);
			this.form = rows[index];
		},
		findPublicacoes() {
			PublicacaoService.listAll('publicacao/list')
				.then(result => {
					this.tableData = result.data; 
				});
		},
		findProjetos() {
			ProjetoService.listAll('projeto/list')
				.then(result => {
					this.projetos = result.data; 
				});
		},
		findCategorias() {
			CategoriaService.listAll('categoriaPublicacao/list')
				.then(result => {
					this.categorias = result.data; 
				});
		}
	},
	mounted() {
		this.findPublicacoes()
		this.findProjetos()
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