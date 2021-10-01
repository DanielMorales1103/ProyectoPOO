public class InfoCentro{
    public void Centro(String[] args) {
    Principal centros;
    centros = new Principal();
    centros.setNombre(nombre);
    centros.setDinero(dinero);
    centros.setMedicina(medicinas);
    centros.setDoctores(doctores);
    centros.setCamas(camas);
    centros.setComida(comida);
    centros.setTanquesOxigeno(tanquesOxigeno);
    centros.setNumero(numero);
    centros.setUbicacion(ubicacion);
    centros.setPacientes(pacientes);
    System.out.print("Nombre del centro: ");
    System.out.print(centros.getNombre());
    System.out.print("\n");
    System.out.print("Localización del centro: ");
    System.out.print(centros.getUbicacion());
    System.out.print("\n");
    System.out.print("Numero de telefono del centro: ");
    System.out.print(centros.getNumero());
    System.out.print("\n");
    System.out.print("Cantidad de doctores del centro: ");
    System.out.print(centros.getDoctores());
    System.out.print("\n");
    System.out.print("Cantidad de pacientes del centro: ");
    System.out.print(centros.getPacientes());
    System.out.print("\n");
    System.out.print("Cantidad de camas del centro: ");
    System.out.print(centros.getCamas());
    System.out.print("\n");
    System.out.print("Cantidad de comida del centro: ");
    System.out.print(centros.getComida());
    System.out.print("\n");
    System.out.print("Cantidad de tanques del centro: ");
    System.out.print(centros.getTanquesOxigeno());

    private String nombre;
    public String getNombre(){
    return nombre;
    }
    public void setNombre(String nombre){
    this.nombre = nombre;
    }
    private Double dinero;
    public Double getDinero(){
    return dinero;
    }
    public void setDinero(Double dinero){
    this.dinero = dinero;
    }
    private Integer medicinas;
    public Integer getMedicina(){
    return medicinas;
    }
    public void setMedicina(Integer medicinas){
    this.medicinas = medicinas;
    }
    private Integer doctores;
    public Integer getDoctores(){
    return doctores;
    }
    public void setDoctores(Integer doctores){
    this.doctores = doctores;
    }
    private Integer pacientes;
    public Integer getPacientes(){
    return pacientes;
    }
    public void setPacientes(Integer pacientes){
    this.pacientes = pacientes;
    }
    private Integer camas;
    public Integer getCamas(){
        return camas;
    }
    public void setCamas(Integer camas){
        this.camas = camas;
    }
    private Integer comida;
    public Integer getComida(){
        return comida;
    }
    public void setComida(Integer comida){
        this.comida = comida;
    }
    private Integer tanquesOxigeno;
    public Integer getTanquesOxigeno(){
        return tanquesOxigeno;
    }
    public void setTanquesOxigeno(Integer tanquesOxigeno){
        this.tanquesOxigeno = tanquesOxigeno;
    }
    private String ubicacion;
    public String getUbicacion(){
        return ubicacion;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    private String numero;
    public String getNumero(){
        return numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
}
}