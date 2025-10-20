
   public abstract class Persona {
    protected String nombre;
    protected String email;
    protected String id;

    public Persona(String nombre, String email, String id) {
        this.nombre = nombre;
        this.email = email;
        this.id = id;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    // Método abstracto (polimorfismo)
    public abstract void mostrarInfo();

    // Sobrecarga de método (polimorfismo)
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }

    public void saludar(String mensaje) {
        System.out.println(mensaje + ", soy " + nombre);
    }
} 

