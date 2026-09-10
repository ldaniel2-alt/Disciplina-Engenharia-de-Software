package mz.gov.mogovolas.expedientes.entity;
import jakarta.persistence.*;
@Entity @Table(name="sectores")
public class Sector { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; @Column(nullable=false,unique=true) String nome; String descricao; public Sector(){} public Sector(String n,String d){nome=n;descricao=d;} public Long getId(){return id;} public String getNome(){return nome;} public String getDescricao(){return descricao;} public void setNome(String x){nome=x;} public void setDescricao(String x){descricao=x;} }
