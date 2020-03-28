import React from 'react';
import { Switch } from 'react-router-dom';

// tslint:disable-next-line:no-unused-variable
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Persona from './persona';
/* needle-add-route-import - add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}/persona`} component={Persona} />
      {/* needle-add-route-path - routes here */}
    </Switch>
  </div>
);

export default Routes;
