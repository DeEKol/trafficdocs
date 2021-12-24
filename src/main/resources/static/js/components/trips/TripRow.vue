<template>
  <div>
    <table>
      <tr>
        <th>id</th>
        <th>itinerary</th>
        <th>date</th>
        <th>quantity</th>
        <th>quantityUnit</th>
        <th>price</th>
      </tr>
      <tr>
        <td>{{ trip.id }}</td>
        <td>{{ trip.itinerary }}</td>
        <td>{{ trip.date }}</td>
        <td>{{ trip.quantity }}</td>
        <td>{{ trip.quantityUnit }}</td>
        <td>{{ trip.price }}</td>
        <td>
          <input type="button" value="Edit" @click="edit" />
          <input type="button" value="X" @click="del" />
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  props: ['trip', 'editTrip', 'deleteTrip', 'trips'],
  methods: {
    edit() {
      this.editTrip(this.trip)
    },
    del() {
      this.deleteTrip(this.trip)
    },
  },
}
</script>

<style scoped></style>
