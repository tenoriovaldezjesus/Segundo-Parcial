public class Main {
    public static void main(String[] args) {
      
        // Ahora: new EstudianteDAOMySQL();   -> guarda en tu MySQL Workbench
        DAO<Estudiante> estudianteDAO = new EstudianteDAOMySQL();

        Estudiante nuevoEstudiante = new Estudiante(2525043, "Jesus Arnulfo Tenorio Valdez"); // Cambia el ID y nombre a los tuyos
        estudianteDAO.guardar(nuevoEstudiante);

        for (Estudiante e : estudianteDAO.obtenerTodos()) {
            System.out.println("ID: " + e.getId() + " | Nombre: " + e.getNombre());
        }
    }
}
