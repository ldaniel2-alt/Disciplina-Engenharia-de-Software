package mz.gov.mogovolas.expedientes.entity;
import jakarta.persistence.*;
@Entity @Table(name="permissoes")
public class Permissao { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; @Column(nullable=false,unique=true) String codigo; @Column(nullable=false) String descricao; public Permissao(){} public Permissao(String c,String d){codigo=c;descricao=d;} public Long getId(){return id;} public String getCodigo(){return codigo;} public String getDescricao(){return descricao;} public void setCodigo(String x){codigo=x;} public void setDescricao(String x){descricao=x;} }
