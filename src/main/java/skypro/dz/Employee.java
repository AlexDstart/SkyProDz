package skypro.dz;

import java.util.Objects;

public class Employee {

        private int id;
        private String firstName;
        private String lastName;
        private String gender;
        private int age;
        private int cityId;

        public Employee(int id, String firstName, String lastName, String gender, int age, int cityId) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.age = age;
            this.cityId = cityId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    ", Имя='" + firstName + '\'' +
                    ", Фамилия='" + lastName + '\'' +
                    ", Пол='" + gender + '\'' +
                    ", Возраст=" + age +
                    ", cityId=" + cityId +
                    "}\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Employee)) return false;
            Employee employee = (Employee) o;
            return getId() == employee.getId() && getAge() == employee.getAge() && getCityId() == employee.getCityId() && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getGender(), employee.getGender());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getFirstName(), getLastName(), getGender(), getAge(), getCityId());
        }
    }
