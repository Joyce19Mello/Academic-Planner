<template lang="pug">
#professores
    .informativo-boasVindas
        p.informativo-titulo Professores
    
    el-row.informativo-sistema

        el-col.informativo-funcoes( :span='8', :key='index', v-for="(professor, index) in professores")
            Card(:professor="professor")

</template>

<script>
import Card from '@/components/element/Card'
import { PROFESSORES } from '@/utils/mocks/professores'

export default {
    name: 'Professores',
    components: { Card },
    data(){
        return {
            professores: PROFESSORES
        }
    }
}
</script>

<style lang="sass">
#professores
    .informativo-boasVindas
        margin-top: 40px

        .informativo-titulo
            font-size: 40px
            margin: 15px 0 0 0
        
    .informativo-sistema
        margin-top: 50px
    
</style>