<template>
  <div>
    <input type="text" placeholder="itinerary" v-model="itinerary" />

    <input type="date" placeholder="date" v-model="date" />
    <input type="text" placeholder="quantity" v-model="quantity" />
    <input
      type="text"
      list="quantityUnitList"
      placeholder="quantityUnit"
      v-model="quantityUnit"
    />
    <datalist id="quantityUnitList">
      <option value="ШТУК"> </option>
      <option value="ЧАСОВ"> </option>
    </datalist>

    <input type="text" placeholder="price" v-model="price" />

    <input type="button" value="Save" @click="save" />
  </div>
</template>

<script>
export default {
  props: ['trips', 'tripAttr'],
  data() {
    return {
      id: '',
      itinerary: '',
      date: '',
      quantity: '',
      quantityUnit: '',
      price: '',
    }
  },
  watch: {
    tripAttr(newVal, oldVal) {
      this.id = newVal.id
      this.itinerary = newVal.itinerary
      this.date = newVal.date
      this.quantity = newVal.quantity
      this.quantityUnit = newVal.quantityUnit
      this.price = newVal.price
    },
  },
  methods: {
    save() {
      if (this.id) {
        axios
          .put('/trip/' + this.id, {
            id: this.id,
            itinerary: this.itinerary,

            date: this.date,
            quantity: this.quantity,
            quantityUnit: this.quantityUnit,
            price: this.price,
          })
          .then((response) => {
            const index = this.trips.findIndex(
              (item) => item.id === response.data.id
            )
            this.trips.splice(index, 1, response.data)
            this.id = ''
            this.text = ''

            this.date = ''
            this.quantity = ''
            this.quantityUnit = ''
            this.price = ''
          })
      } else {
        axios
          .post('/trip', {
            itinerary: this.itinerary,

            date: this.date,
            quantity: this.quantity,
            quantityUnit: this.quantityUnit,
            price: this.price,
          })
          .then((response) => {
            this.trips.push(response.data)
            this.text = ''

            this.date = ''
            this.quantity = ''
            this.quantityUnit = ''
            this.price = ''
          })
      }
    },
  },
}
</script>

<style scoped></style>
