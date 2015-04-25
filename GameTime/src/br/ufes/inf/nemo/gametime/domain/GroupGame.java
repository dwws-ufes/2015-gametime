package br.ufes.inf.nemo.gametime.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class GroupGame extends  PersistentObjectSupport{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	
	private String descricao;
	
	private boolean isactive; 
	
	/*  ADMINISTRADOR DO GRUPO  */
	@ManyToOne 	@NotNull
	private User adminUser;
	
	/* LISTA DE USUARIOS PERTENCENTES AOS GRUPOS  */
	@ManyToMany 
	@JoinTable(
		name="GroupGame_User",joinColumns = {@JoinColumn(name="GROUPGAME_ID" , referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="USER_ID" , referencedColumnName="ID")})
	private Set<User> usersMembers;
	
	/* CONTAS PARA SEREM USADAS PELOS USUARIOS DESSE GRUPO  */
	@OneToMany(mappedBy="groupGame")
	private Set<GameAccount>  gameAccounts;

	
	
	/*  CONSTRUTOR  */
	public GroupGame(User adminUser){
		this.adminUser = adminUser;
	}
	
	

	/*  GETS AND SETS*/
	public User getAdminUser() { return adminUser; }
	public void setAdminUser(User adminUser) { 	this.adminUser = adminUser; }

	public Set<User> getUsersMembers() { return usersMembers;  }
	public void setUsersMembers(Set<User> usersMembers) {  this.usersMembers = usersMembers; }

	public Set<GameAccount> getGameAccounts() { return gameAccounts;  }
	public void setGameAccounts(Set<GameAccount> gameAccounts) { this.gameAccounts = gameAccounts; }
	
}
