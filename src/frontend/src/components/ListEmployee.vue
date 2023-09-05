<template>
  <div class="mt-5 container employee-form">
    <table class="table">
      <thead class="table-dark">
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Salario</th>
          <th>Edad</th>
          <th>Salario anual</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="employee in employees" :key="employee.id">
          <td>{{ employee.id }}</td>
          <td>{{ employee.employee_name }}</td>
          <td>{{ employee.employee_salary }}</td>
          <td>{{ employee.employee_age }}</td>
          <td>{{ employee.salary_anual }}</td>
        </tr>
      </tbody>
    </table>
    <div>
      <div class="alert alert-danger" v-if="messageError" role="alert">
        {{ messageError }}
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import axios from "axios";

interface Employee {
  id: number;
  employee_name: string;
  employee_salary: number;
  employee_age: number;
  profile_image: string;
  salary_anual: number;
}

const employees = ref<Employee[]>([]);

const messageError = ref<String>("");

// Watcher para la propiedad employee.id
// watch(employee.value, async (newEmployee, oldEmployee) => {
//   if (newEmployee.id !== oldEmployee.id) {
//     await fetchEmployee();
//   }
// });
// Método para obtener la lista de empleados
async function fetchEmployees() {
  try {
    const response = await axios.get("http://localhost:8080/api/employees");
    console.log(response);
    if (response.data.message == "SUCCESS") {
      messageError.value = "";

      employees.value = response.data.data;
      console.log(employees.value);
    } else {
      messageError.value = " lo sentimos ha ocurrido un error en la consulta";
    }
  } catch (error) {
    console.error(error);
    messageError.value = " lo sentimos ha ocurrido un error en la consulta";
  }
}

// Llamada inicial para obtener la lista de empleados al cargar el componente
onMounted(() => {
  fetchEmployees();
});
</script>

<style scoped>
/* Estilos para la tabla */
</style>
