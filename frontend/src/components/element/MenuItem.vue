<template lang="pug">
#menu-item(:class="{ active: active }" @click="click" @mouseover="hover(true)" @mouseleave="hover(false)")
  .menu-title
    i.lnr.icone(:class="icone")
    span.margem {{ titulo }}
  .indicator2
</template>
<script>
export default {
  name: 'MenuItem',
  props: ['titulo', 'icone', 'active'],
  methods: {
    /**
     * Retorna o evento de click
     */
    click () {
      this.$emit('click')
    },
    /**
     * Retorna para o componente que chamou o estado do hover
     *
     * @param value
     */
    hover (value) {
      this.$emit('hover', value)
    }
  }
}
</script>

<style lang="sass" scoped>
#menu-item
  padding: 0 30px
  justify-content: center
  cursor: pointer
  user-select: none

  .menu-title
    display: flex
    align-items: baseline
    margin-top: 6px

    .margem
      font-size: 16px
      color: #424242
      font-weight: normal !important
      margin: 20px 0
      white-space: nowrap

  &:hover
    background-color: rgba(255, 255, 255, 0.1)

    .indicator2
      background-color: #999

  .icone
    margin-right: 10px
    color: #57BC90
    font-size: 16px

  .indicator2
    width: 100%
    height: 4px
    border-radius: 2px 2px 0 0

#menu-item.active

  .indicator2
    background-color: #57BC90
</style>
