package net.iterart.tareas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.iterart.tareas.entities.Tarea;
import net.iterart.tareas.jdbc.ConnectionFactory;

public class TareaRepo {

	List<Tarea> tareas;

	public TareaRepo() {
		tareas = new ArrayList<>();

		cargarDatos();
	}

	void cargarDatos() {
		String sql = "select * from tareas";

		try {
			// Objeto de conexión:
			Connection cn = new ConnectionFactory().getConnection();

			// Preparar la primer sentencia sql:
			PreparedStatement ps = cn.prepareStatement(sql);

			// Crear objeto de conjunto de resultados de consulta sql:
			ResultSet rs = ps.executeQuery(); // Ejecutar sentencia...

			// Recorrer las tareas cargadas de la bd:
			while (rs.next()) {

				// Transformar los resultados en objeto :
				Tarea tarea = new Tarea();
				tarea.setNumero(rs.getInt(1));
				tarea.setDescripcion(rs.getString(2));
				tarea.setFecha(rs.getDate(3));
				tarea.setRealizada(rs.getBoolean(4));

				// Añadir a la lista del repo...
				tareas.add(tarea);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}


}
