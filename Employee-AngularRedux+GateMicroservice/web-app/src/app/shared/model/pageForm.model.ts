export const enum PAGE_MODE {
  DETAILS = 'DETAILS',
  EDIT = 'EDIT',
  CREATE = 'CREATE'
}

export interface PageForm {
  pageMode: PAGE_MODE;
  id?: string;
}
