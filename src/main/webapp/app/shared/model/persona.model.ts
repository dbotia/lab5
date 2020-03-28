export interface IPersona {
  id?: number;
  nombre?: string;
  email?: string;
  direccion?: string;
  salario?: number;
}

export const defaultValue: Readonly<IPersona> = {};
