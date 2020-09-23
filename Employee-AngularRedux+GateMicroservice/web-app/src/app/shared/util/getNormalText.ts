import {PAGE_MODE, PageForm} from '../model/model';
import {ActivatedRoute} from '@angular/router';

export const getPageModel = (activatedRoute: ActivatedRoute): PageForm => {
  const id = activatedRoute.snapshot.params.id;
  const path = activatedRoute.snapshot.url[0].path;
  if (id) {
    if (path === `edit`) {
      return { pageMode: PAGE_MODE.EDIT, id};
    } else {
      return { pageMode: PAGE_MODE.DETAILS, id};
    }
  } else {
    return { pageMode: PAGE_MODE.CREATE};
  }

};
