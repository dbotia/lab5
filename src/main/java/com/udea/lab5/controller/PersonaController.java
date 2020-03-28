package com.udea.lab5.controller;

import com.udea.lab5.com.udea.lab5.modelo.Persona;
import com.udea.lab5.repository.PersonaRepository;
import com.udea.lab5.controller.util.HeaderUtil;
import static com.udea.lab5.security.AuthoritiesConstants.USER;
import org.slf4j.Logger;
import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response.ResponseBuilder;
import com.udea.lab5.controller.util.Page;
import com.udea.lab5.controller.util.PaginationUtil;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

/**
 * REST controller for managing Persona.
 */
@Path("/api/persona")
@RolesAllowed(USER)
public class PersonaController {

    @Inject
    private Logger log;

    @Inject
    private PersonaRepository personaRepository;

    private static final String ENTITY_NAME = "persona";

    /**
     * POST : Create a new persona.
     *
     * @param persona the persona to create
     * @return the Response with status 201 (Created) and with body the new
     * persona, or with status 400 (Bad Request) if the persona has already an
     * ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @Timed
    @Operation(summary = "create a new persona", description = "Create a new persona")
    @APIResponse(responseCode = "201", description = "Created")
    @APIResponse(responseCode = "400", description = "Bad Request")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPersona(Persona persona) throws URISyntaxException {
        log.debug("REST request to save Persona : {}", persona);
        personaRepository.create(persona);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/persona/" + persona.getId())),
                ENTITY_NAME, persona.getId().toString())
                .entity(persona).build();
    }

    /**
     * PUT : Updates an existing persona.
     *
     * @param persona the persona to update
     * @return the Response with status 200 (OK) and with body the updated
     * persona, or with status 400 (Bad Request) if the persona is not valid, or
     * with status 500 (Internal Server Error) if the persona couldn't be
     * updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @Timed
    @Operation(summary = "update persona", description = "Updates an existing persona")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(responseCode = "400", description = "Bad Request")
    @APIResponse(responseCode = "500", description = "Internal Server Error")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePersona(Persona persona) throws URISyntaxException {
        log.debug("REST request to update Persona : {}", persona);
        personaRepository.edit(persona);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), ENTITY_NAME, persona.getId().toString())
                .entity(persona).build();
    }

    /**
     * GET : get all the personas.
     *
     * @param page the pagination information
     * @param size the pagination size information
     *
     * @return the Response with status 200 (OK) and the list of personas in
     * body
     * @throws URISyntaxException if there is an error to generate the
     * pagination HTTP headers
     */
    @Timed
    @Operation(summary = "get all the personas")
    @APIResponse(responseCode = "200", description = "OK")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout
    public Response getAllPersonas(@QueryParam("page") int page, @QueryParam("size") int size) throws URISyntaxException {
        log.debug("REST request to get all Personas");
        List<Persona> personas = personaRepository.findRange(page * size, size);
        ResponseBuilder builder = Response.ok(personas);
        PaginationUtil.generatePaginationHttpHeaders(builder, new Page(page, size, personaRepository.count()), "/resources/api/persona");
        return builder.build();
    }

    /**
     * GET /:id : get the "id" persona.
     *
     * @param id the id of the persona to retrieve
     * @return the Response with status 200 (OK) and with body the persona, or
     * with status 404 (Not Found)
     */
    @Timed
    @Operation(summary = "get the persona")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(responseCode = "404", description = "Not Found")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersona(@PathParam("id") Long id) {
        log.debug("REST request to get Persona : {}", id);
        Persona persona = personaRepository.find(id);
        return Optional.ofNullable(persona)
                .map(result -> Response.status(Response.Status.OK).entity(persona).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" persona.
     *
     * @param id the id of the persona to delete
     * @return the Response with status 200 (OK)
     */
    @Timed
    @Operation(summary = "remove the persona")
    @APIResponse(responseCode = "200", description = "OK")
    @APIResponse(responseCode = "404", description = "Not Found")
    @DELETE
    @Path("/{id}")
    public Response removePersona(@PathParam("id") Long id) {
        log.debug("REST request to delete Persona : {}", id);
        personaRepository.remove(personaRepository.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), ENTITY_NAME, id.toString()).build();
    }

}
