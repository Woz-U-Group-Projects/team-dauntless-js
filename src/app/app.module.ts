import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// Angular Routing
import { AppRoutingModule } from './app-routing.module';

// HTTP Methods
import { HttpClientModule } from '@angular/common/http';

// Phaser module
import { PhaserModule } from 'phaser-component-library';

// Flexlayout Modules
import { FlexLayoutModule } from '@angular/flex-layout';

// Browser Animations
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Material Design Components
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule, MatCard } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';

// Application Component's
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

// Authentication components
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';

// Game and Leaderboard components
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { GameComponent } from './game/game.component';

// Application Service's
import { UserService } from './services/user.service';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    LeaderboardComponent,
    GameComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    PhaserModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule
  ],
  providers: [ UserService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
