public class Arquitecto {
    private String codigo;
    private String nombres;
    private CondicionContrato condicionContrato;
    private Especialidad especialidad;
    private TipoSupervision tipoSupervision;
    private int numeroObrasAsignadas;
    
    private Arquitecto(Builder builder) {
        this.codigo = builder.codigo;
        this.nombres = builder.nombres;
        this.condicionContrato = builder.condicionContrato;
        this.especialidad = builder.especialidad;
        this.tipoSupervision = builder.tipoSupervision;
        this.numeroObrasAsignadas = builder.numeroObrasAsignadas;
    }
    
    public String getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public CondicionContrato getCondicionContrato() { return condicionContrato; }
    public Especialidad getEspecialidad() { return especialidad; }
    public TipoSupervision getTipoSupervision() { return tipoSupervision; }
    public int getNumeroObrasAsignadas() { return numeroObrasAsignadas; }
    
    public static class Builder {
        private String codigo;
        private String nombres;
        private CondicionContrato condicionContrato;
        private Especialidad especialidad;
        private TipoSupervision tipoSupervision;
        private int numeroObrasAsignadas;
        
        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }
        
        public Builder nombres(String nombres) {
            this.nombres = nombres;
            return this;
        }
        
        public Builder condicionContrato(CondicionContrato condicionContrato) {
            this.condicionContrato = condicionContrato;
            return this;
        }
        
        public Builder especialidad(Especialidad especialidad) {
            this.especialidad = especialidad;
            return this;
        }
        
        public Builder tipoSupervision(TipoSupervision tipoSupervision) {
            this.tipoSupervision = tipoSupervision;
            return this;
        }
        
        public Builder numeroObrasAsignadas(int numeroObrasAsignadas) {
            this.numeroObrasAsignadas = numeroObrasAsignadas;
            return this;
        }
        
        public Arquitecto build() {
            if (codigo == null || codigo.isEmpty()) {
                throw new IllegalStateException("El código es obligatorio");
            }
            if (nombres == null || nombres.isEmpty()) {
                throw new IllegalStateException("El nombre es obligatorio");
            }
            return new Arquitecto(this);
        }
    }
    
    @Override
    public String toString() {
        return String.format("Arquitecto[%s - %s, %s, %s, %s, %d obras]",
                codigo, nombres, condicionContrato, especialidad, 
                tipoSupervision, numeroObrasAsignadas);
    }
}