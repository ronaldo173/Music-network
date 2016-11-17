package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "liked_music")
public class LikedMusic implements Serializable {

	private static final long serialVersionUID = 4783458147228760079L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "id_user")
	private Long idUser;

	@Column(name = "id_music")
	private Long idMusic;

	public LikedMusic() {
		super();
	}

	public LikedMusic(Long id, Long idUser, Long idMusic) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idMusic = idMusic;
	}

	public LikedMusic(LikedMusic likedMusic) {
		super();
		this.id = likedMusic.id;
		this.idUser = likedMusic.idUser;
		this.idMusic = likedMusic.idMusic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LikedMusic [id=" + id + ", idUser=" + idUser + ", idMusic=" + idMusic + "]";
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdMusic() {
		return idMusic;
	}

	public void setIdMusic(Long idMusic) {
		this.idMusic = idMusic;
	}

}
