package br.ufpb.pas.pratica1;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DisciplinasController {
	
	@Autowired
	private DisciplinasService disciplinaService;
	
	@RequestMapping(value = "/disciplinas", method = RequestMethod.POST)
	public ResponseEntity<Disciplina> novaDisciplina(@RequestBody Disciplina disciplina){
		return new ResponseEntity<Disciplina>(
				this.disciplinaService.setNovaDisciplina(disciplina.getNome(), disciplina.getNota()), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/disciplinas", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Disciplina>> getDisciplinas(){
		return new ResponseEntity<ArrayList<Disciplina>>(disciplinaService.getDisciplinas(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/disciplinas/{id}", method = RequestMethod.GET)
	public ResponseEntity<Disciplina> getById(@PathVariable("id")int id){
		Disciplina temp = this.disciplinaService.getDisciplinaById(id);
		
		if(temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Disciplina>(temp, HttpStatus.FOUND);
		}
	}
	
	@RequestMapping(value = "/disciplinas/{id}/nome", method = RequestMethod.PUT)
	public ResponseEntity<Disciplina> updateNameById(@PathVariable("id")int id, @RequestBody Disciplina desc){
		Disciplina temp = this.disciplinaService.updateName(id, desc.getNome());
		
		if(temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Disciplina>(temp, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/disciplinas/{id}/nota", method = RequestMethod.PUT)
	public ResponseEntity<Disciplina> updateNotaById(@PathVariable("id")int id, @RequestBody Double nota){
		Disciplina temp = this.disciplinaService.updateNota(id, nota);
		
		if(temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}else {
			return new ResponseEntity<Disciplina>(temp, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/disciplinas/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Disciplina> deleteById(@PathVariable("id")int id){
		Disciplina temp = this.disciplinaService.deleteDisciplinaById(id);
		
		if(temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Disciplina>(temp, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/disciplinas/ranking", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Disciplina>> getDisciplinasByRanking(){
		return new ResponseEntity<ArrayList<Disciplina>>(this.disciplinaService.getDisciplinasByRanking(), HttpStatus.OK);
	}
}
