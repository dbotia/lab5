import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './persona.reducer';
import { IPersona } from 'app/shared/model/persona.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IPersonaDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class PersonaDetail extends React.Component<IPersonaDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { personaEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="lab5App.persona.detail.title">Persona</Translate> [<b>{personaEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="nombre">
                <Translate contentKey="lab5App.persona.nombre">nombre</Translate>
              </span>
            </dt>
            <dd>{personaEntity.nombre}</dd>
            <dt>
              <span id="email">
                <Translate contentKey="lab5App.persona.email">email</Translate>
              </span>
            </dt>
            <dd>{personaEntity.email}</dd>
            <dt>
              <span id="direccion">
                <Translate contentKey="lab5App.persona.direccion">direccion</Translate>
              </span>
            </dt>
            <dd>{personaEntity.direccion}</dd>
            <dt>
              <span id="salario">
                <Translate contentKey="lab5App.persona.salario">salario</Translate>
              </span>
            </dt>
            <dd>{personaEntity.salario}</dd>
          </dl>
          <Button tag={Link} to="/entity/persona" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/persona/${personaEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ persona }: IRootState) => ({
  personaEntity: persona.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(PersonaDetail);
