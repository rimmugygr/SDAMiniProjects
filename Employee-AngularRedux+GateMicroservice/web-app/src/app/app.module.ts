import {APP_INITIALIZER, NgModule} from '@angular/core';
import { AppComponent } from './app.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import {AppRoutingModule} from './app-routing.module';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {NgxsModule} from '@ngxs/store';
import {environment} from '../environments/environment';
import {StateClass} from '@ngxs/store/internals';
import {NgxsStoragePluginModule, StorageOption} from '@ngxs/storage-plugin';
import {NgxsReduxDevtoolsPluginModule} from '@ngxs/devtools-plugin';
import {EmployeesState} from './shared/state/employees/employees.state';
import {NgxMaskModule} from 'ngx-mask';
import {UiState} from './shared/state/ui/ui.state';
import {RouteHandler} from './shared/handler/route.handler';
import {AlertHandler} from './shared/handler/alert.handler';


const persistentStates: StateClass<any>[] = [EmployeesState];
const states: StateClass<any>[] = [...persistentStates, UiState];

const initFn = () => () => { /* use for some initialization stuff */ };

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent
  ],
    imports: [
      BrowserModule,
      AppRoutingModule,
      HttpClientModule,
      NgxMaskModule.forRoot(),
      NgxsModule.forRoot(states, {developmentMode: !environment.production}),
      NgxsStoragePluginModule.forRoot({ key: persistentStates, storage: StorageOption.LocalStorage}),
      NgxsReduxDevtoolsPluginModule.forRoot({disabled: environment.production})
    ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initFn,
      deps: [RouteHandler, AlertHandler],
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
