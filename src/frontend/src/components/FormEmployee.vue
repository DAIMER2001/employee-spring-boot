<template>
  <div class="container employee-form">
    
  <div class="form-body">
        <div class="row">
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        <h3>Buscar Empleado por ID</h3>
                        <form class="requires-validation" novalidate>
                            <div class="col-md-12">
                                <input v-model="employee.id" class="form-control" type="number" name="id" placeholder="ID" >
                                 <div class="valid-feedback">ID field is valid!</div>
                                 <div class="invalid-feedback">ID field cannot be blank!</div>
                            </div>

                            <div class="col-md-12">
                               <input  v-model="employee.employee_name" class="form-control" type="text" name="name" placeholder="Full Name" required>
                            </div>

                            <div class="col-md-12">
                               <input  v-model="employee.employee_salary" class="form-control" type="text" name="employee_salary" placeholder="Salary" required>
                            </div>

                            <div class="col-md-12">
                               <input  v-model="employee.employee_age" class="form-control" type="text" name="employee_age" placeholder="Age" required>
                            </div>

                            <div class="col-md-12">
                               <input  v-model="employee.profile_image" class="form-control" type="text" name="profile_image" placeholder="Image" required>
                            </div>

                            <div class="col-md-12">
                              <input  v-model="employee.salary_anual" class="form-control" type="text" name="salary_anual" placeholder="Salary Anual" required>
                            </div>

                            <div class=" form-button mt-3">
                                <a id="submit" @click="fetchEmployee()" class="btn btn-success">Buscar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


      <div class="mt-4" v-if="messageError">
        <div class="alert alert-danger" role="alert">
        {{ messageError }}
        </div>
      </div>
  </div>
</template>


<script setup lang="ts">
import { ref, watch, onMounted, Ref } from 'vue';
import axios from 'axios';

interface Employee {
  id: string;
  employee_name: string;
  employee_salary: string;
  employee_age: string;
  profile_image: string;
  salary_anual: string;
}

// const employeeId = Ref(0)

const employee: Ref<Employee> = ref({
  id: "",
  employee_name: "",
  employee_salary: "",
  employee_age: "",
  profile_image: "",
  salary_anual: "",
});

const messageError = ref<String>("")


const cleanEmployee = () => {
      console.log("clean employee")
    employee.value.employee_name =  ""
    employee.value.employee_salary = ""
    employee.value.employee_age = ""
    employee.value.profile_image =  ""
    employee.value.salary_anual = ""
}

// Método para buscar el empleado
const  fetchEmployee = async () => {
  try {
    messageError.value = ""
    const response = await axios.get(`http://localhost:8080/api/employee/${employee.value.id}`);
    console.log(employee.value.id)
    console.log(response)
    if (response.data.message = "SUCCESS") {
      employee.value = response.data.data; 
      console.log(employee.value)
    } else {
      console.log("clean employee")
      messageError.value = " lo sentimos ha ocurrido un error en la consulta"
      cleanEmployee()
    }
  } catch (error) {
      console.log("clean employee")
      messageError.value = " lo sentimos ha ocurrido un error en la consulta"
      cleanEmployee()
  }
}


</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;900&display=swap');

*, body {
    font-family: 'Poppins', sans-serif;
    font-weight: 400;
    -webkit-font-smoothing: antialiased;
    text-rendering: optimizeLegibility;
    -moz-osx-font-smoothing: grayscale;
}

html, body {
    height: 100%;
    background-color: #152733;
    overflow: hidden;
}

.form-holder {
      flex-direction: column;
      justify-content: center;
      align-items: center;
      text-align: center;
}

.form-holder .form-content {
    position: relative;
    text-align: center;
    display: -webkit-box;
    display: -moz-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-align-items: center;
    align-items: center;
    padding: 60px;
}

.form-content .form-items {
    border: 3px solid #000000;
    padding: 40px;
    display: inline-block;
    width: 100%;
    min-width: 540px;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
    text-align: left;
    -webkit-transition: all 0.4s ease;
    transition: all 0.4s ease;
}

.form-content h3 {
    color: #351d1d;
    text-align: left;
    font-size: 28px;
    font-weight: 600;
    margin-bottom: 5px;
}

.form-content h3.form-title {
    margin-bottom: 30px;
}

.form-content p {
    color: #170000;
    text-align: left;
    font-size: 17px;
    font-weight: 300;
    line-height: 20px;
    margin-bottom: 30px;
}


.form-content label, .was-validated .form-check-input:invalid~.form-check-label, .was-validated .form-check-input:valid~.form-check-label{
    color: #7bae8c66;
}

.form-content input[type=text], .form-content input[type=password], .form-content input[type=email], .form-content select {
    width: 100%;
    padding: 9px 20px;
    text-align: left;
    border: 0;
    outline: 0;
    border-radius: 6px;
    background-color: #8cc39746;
    font-size: 15px;
    font-weight: 300;
    color: #070404;
    -webkit-transition: all 0.3s ease;
    transition: all 0.3s ease;
    margin-top: 16px;
}


.btn-primary{
    background-color: #067d04;
    outline: none;
    border: 0px;
     box-shadow: none;
}

.btn-primary:hover, .btn-primary:focus, .btn-primary:active{
    background-color: #495056;
    outline: none !important;
    border: none !important;
     box-shadow: none;
}

.form-content textarea {
    position: static !important;
    width: 100%;
    padding: 8px 20px;
    border-radius: 6px;
    text-align: left;
    background-color: #9bb78c0d;
    border: 0;
    font-size: 15px;
    font-weight: 300;
    color: #190000;
    outline: none;
    resize: none;
    height: 120px;
    -webkit-transition: none;
    transition: none;
    margin-bottom: 14px;
}

.form-content textarea:hover, .form-content textarea:focus {
    border: 0;
    background-color: #000000;
    color: #000000;
}

.mv-up{
    margin-top: -9px !important;
    margin-bottom: 8px !important;
}

.invalid-feedback{
    color: #ff606e;
}

.valid-feedback{
   color: #2acc80;
}
</style>